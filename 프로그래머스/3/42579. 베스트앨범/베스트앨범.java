import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
		public int[] solution(String[] genres, int[] plays) {
			// genres : 노래 장르 배열
			// plays : 노래별 재생 횟수 배열 
	        int[] answer = {};
	        
	        // 베스트 앨범 기준
	        // 1. 속한 노래가 많이 재생된 장르 먼저 (장르 전체 재생횟수) 
	        // 2. 장르 내에서 많이 재생된 노래 먼저
	        // 3. 재생 횟수가 같은 경우 고유 번호가 낮은 노래 먼저 
	        
	        // 장르별 전체 재생횟수 <장르, 횟수>
	        HashMap<String, Integer> genres_count = new HashMap<String, Integer>();
	        // 노래별 재생횟수 <장르, 장르별 노래 리스트>
	        HashMap<String, List<int[]>> songsByGenre = new HashMap<String, List<int[]>>();
	        
	        for(int i=0; i<genres.length; i++) {
	        	// i번째 곡의 장르 이름 
	        	String genre = genres[i];
	        	// i번째 곡의 재생횟수
	        	int count = plays[i];
	        	
	        	// 장르별 전체 재생횟수 추가 
	        	genres_count.put(genre, genres_count.getOrDefault(genre, 0)+count);
	        	
	        	// 노래별 재생횟수
	        	int[] tmp = {i, count};
	        	List<int[]> songList = songsByGenre.get(genre);
	        	if(songList == null) {
	        		songList = new ArrayList<>();
	                songsByGenre.put(genre, songList);
	        	}
	        	songList.add(tmp);
	        	songsByGenre.put(genre, songList);	        	
	        }
	        
	        // 재생횟수가 가장 많은 장르 순서대로 (내림차순) 
	        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genres_count.entrySet());
	        sortedGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())); // 내림차순 정렬
	        
	        // 베스트 앨범 수록 <번호>
	        List<Integer> bestAlbum = new ArrayList<Integer>();
	        
	        for (Map.Entry<String, Integer> entry : sortedGenres) {
	            String genre = entry.getKey();
	            
	            // 해당 장르의 노래 리스트 가져오기
	            List<int[]> songs = songsByGenre.get(genre);
	            
	            // 장르 내 노래 정렬: 재생 횟수 내림차순, 고유 번호 오름차순
                songs.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] song1, int[] song2) {
                        // song1[1] = 재생 횟수, song1[0] = 고유 번호
                        if (song1[1] != song2[1]) {
                            // 재생 횟수가 다르면, 횟수가 많은 노래(내림차순) 우선
                            return Integer.compare(song2[1], song1[1]); 
                        } else {
                            // 재생 횟수가 같으면, 고유 번호가 낮은 노래(오름차순) 우선
                            return Integer.compare(song1[0], song2[0]);
                        }
                    }
                });
                
                // 장르별 최대 2개의 노래 선택하여 고유 번호 추가
                for (int i = 0; i < songs.size() && i < 2; i++) {
                    // songs.get(i)[0]은 고유 번호(id)이다.
                    bestAlbum.add(songs.get(i)[0]);
                }
	        }
	        
	        // 최종 결과 반환 
            // List<Integer>를 int[] 배열로 변환
	        answer = bestAlbum.stream().mapToInt(Integer::intValue).toArray();
	        return answer;
	    }
	}