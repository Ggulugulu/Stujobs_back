package com.example.stujobs.service;

import com.example.stujobs.mapper.JobsMapper;
import com.example.stujobs.mapper.R_LikeMapper;
import com.example.stujobs.pojo.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RecommendationService {
    @Autowired
    private R_LikeMapper mapper;
    @Autowired
    private JobsMapper jMapper;

    private Map<Integer, List<Integer>> getUserToJobsMap() {
        Map<Integer, List<Integer>> userToJobs = new HashMap<>();
        List<Map<String, Object>> results =mapper.selectJoinJobs();
        for (Map<String, Object> result : results) {
            int userId = (int) result.get("user_id");
            int jobId = (int) result.get("job_id");
            String tags = (String) result.get("tags");
            if (!userToJobs.containsKey(userId)) {
                userToJobs.put(userId, new ArrayList<>());
            }
            userToJobs.get(userId).add(jobId);
        }
        //System.out.println(userToJobs);
        return userToJobs;
    }

    public List<Jobs> recommendJobs(int userId) {
        //获取映射关系
        Map<Integer, List<Integer>> userToJobs = getUserToJobsMap();
        //不存在该用户返回空列表
        if (!userToJobs.containsKey(userId)) {
            System.out.println("没有该用户");
            return new ArrayList<>();
        }
        //jobIds是目标用户所有喜欢的工作id
        List<Integer> jobIds = userToJobs.get(userId);
        Map<Integer, Double> jobSimilarityMap = new HashMap<>();
        for (int jobId : jobIds) {
            //本轮用户
            for (int otherUserId : userToJobs.keySet()) {
                if (otherUserId == userId) {
                    continue;
                }
                double similarity = 0.0;
                List<Integer> otherUserJobIds = userToJobs.get(otherUserId);
                //获取其他用户的喜欢列表
                for (int otherUserJobId : otherUserJobIds) {
                    //如果本轮用户喜欢的工作与目标用户的工作相同，设置相似度为1
                    if (otherUserJobId == jobId) {
                        similarity = 1.0;
                        break;
                    }
                    //否则用标签的相似度代替工作的相似度
                    String jobTags = mapper.selectTagsByJobId(jobId);
                    String otherJobTags = mapper.selectTagsByJobId(otherUserJobId);
                    similarity = calculateTagsSimilarity(jobTags, otherJobTags);

                    System.out.println(similarity);
                    if(similarity > 0){
                        jobSimilarityMap.put(otherUserJobId,similarity);
                    }
                }
                if (similarity > 0) {
                    jobSimilarityMap.put(jobId,similarity);
                    System.out.println(jobSimilarityMap);
//                    double previousSimilarity = jobSimilarityMap.getOrDefault(jobId, 0.0);
//                    jobSimilarityMap.put(jobId, previousSimilarity + similarity);
                }
            }
        }
        //System.out.println(jobSimilarityMap);

        List<Map.Entry<Integer, Double>> jobSimilarityList = new ArrayList<>(jobSimilarityMap.entrySet());
        jobSimilarityList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println(jobSimilarityList);

        List<Jobs> recommendedJobs = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : jobSimilarityList) {
            //System.out.println(entry);
            Integer jobId = entry.getKey();
            System.out.println(jobId);
            if (!jobIds.contains(jobId)) {
                recommendedJobs.add(jMapper.selectByPrimaryKey(jobId));
            }
            if (recommendedJobs.size() >= 5) {
                break;
            }
        }
        return recommendedJobs;
    }
    private double calculateTagsSimilarity(String tags1, String tags2) {
        //将两个工作职位的标签分别分词并去重，计算它们的交集和并集。
        // 计算它们的 Jaccard 相似度
        Set<String> tagSet1 = new HashSet<>(Arrays.asList(tags1.split(",")));
        Set<String> tagSet2 = new HashSet<>(Arrays.asList(tags2.split(",")));
        Set<String> intersection = new HashSet<>(tagSet1);
        intersection.retainAll(tagSet2);
        int intersectionSize = intersection.size();
        int unionSize = tagSet1.size() + tagSet2.size() - intersectionSize;
        if (unionSize == 0) {
            return 0;
        }
        //   |A ∩ B| / |A ∪ B|
        double similarity = (double) intersectionSize / unionSize;
        //System.out.println(similarity);
        return similarity;
    }

//    public List<Integer> recommendJobs(int targetUserId) {
//        // 获取用户和作业的映射
//        Map<Integer, List<Integer>> userToJobs = getUserToJobsMap();
//        // 计算用户之间的相似度
//        Map<Integer, Map<Integer, Double>> userSimilarities = new HashMap<>();
//        for (int userId1 : userToJobs.keySet()) {
//            Map<Integer, Double> similarities = new HashMap<>();
//            for (int userId2 : userToJobs.keySet()) {
//                if (userId1 != userId2) {
//                    double similarity = cosineSimilarity(userToJobs.get(userId1), userToJobs.get(userId2));
//                    similarities.put(userId2, similarity);
//                }
//            }
//            userSimilarities.put(userId1, similarities);
//        }
//        // 找到最相似的用户
//        int mostSimilarUserId = -1;
//        double highestSimilarity = -1;
//        for (int userId : userSimilarities.get(targetUserId).keySet()) {
//            double similarity = userSimilarities.get(targetUserId).get(userId);
//            if (similarity > highestSimilarity) {
//                highestSimilarity = similarity;
//                mostSimilarUserId = userId;
//            }
//        }
//        // 推荐作业
//        List<Integer> targetUserJobs = userToJobs.get(targetUserId);
//        List<Integer> mostSimilarUserJobs = userToJobs.get(mostSimilarUserId);
//        List<Integer> recommendedJobs = new ArrayList<>();
//        for (int jobId : mostSimilarUserJobs) {
//            if (!targetUserJobs.contains(jobId)) {
//                recommendedJobs.add(jobId);
//            }
//        }
//        return recommendedJobs;
//    }
    // 获取用户和jobs的映射

//    // 计算两个向量之间的余弦相似度
//    private double cosineSimilarity(List<Integer> v1, List<Integer> v2) {
//        Set<Integer> intersection = new HashSet<>(v1);
//        intersection.retainAll(v2);
//        if (intersection.isEmpty()) {
//            return 0;
//        }
//        double dotProduct = 0;
//        double norm1 = 0;
//        double norm2 = 0;
//        for (int jobId : intersection) {
//            dotProduct += 1;
//            norm1 += 1;
//            norm2 += 1;
//        }
//        double similarity = dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
//        return similarity;
//    }


}
