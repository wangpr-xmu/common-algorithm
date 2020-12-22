package org.worker.hnalgorithm.queue.scattered;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 视频和图片组成的推荐结果打散
 * 1. 视频之间的相对顺序不变，图片之间的相对顺序不变
 * 2. 视频之间至少要间隔一定的距离才可以出现一张图片
 */
public class RecommendedResults {

    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("v_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");

        List<String> recommendedResults = new RecommendedResults().getRecommendedResults(picAndVideoList, 3);
        recommendedResults.forEach((item) -> System.out.println(item));
    }
    public List<String> getRecommendedResults(List<String> picAndVideos, int maxInterval) {
        List<String> result = new ArrayList<>();
        if(null == picAndVideos || picAndVideos.size() == 0) {
            return result;
        }

        int index = 0;
        boolean firstPic = false;
        //第一张图片之前的视频先放入result
        while(!firstPic && index < picAndVideos.size()) {
            if(isVideo(picAndVideos.get(index))) {
                result.add(index, picAndVideos.get(index));
                index++;
            }else {
                firstPic = true;
            }
        }
        //剩余的部分先存入两个队列
        Queue<String> videos = new LinkedList<>();
        Queue<String> piCs = new LinkedList<>();
        while(index < picAndVideos.size()) {
            if(isVideo(picAndVideos.get(index))) {
                videos.add(picAndVideos.get(index));
            }else {
                piCs.add(picAndVideos.get(index));
            }
            index++;
        }
        int interval = result.size();
        while(!videos.isEmpty() && !piCs.isEmpty()) {
            if(interval >= maxInterval) {
                result.add(piCs.poll());
                interval = 0;
            }else {
                result.add(videos.poll());
                interval++;
            }
        }

        while(!videos.isEmpty()) {
            result.add(videos.poll());
        }
        if(interval >= maxInterval && !piCs.isEmpty()) {
            result.add(piCs.poll());
        }
        return result;
    }

    private boolean isVideo(String s) {
        if(s.indexOf('v') != -1) {
            return true;
        }
        return false;
    }
}
