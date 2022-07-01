package com.githrd.www.util;

/**
 * 이 클래스는 파일 업로드에 필요한 기능을 처리하기 위해서
 * 만든 유틸리티적인 클래스
 * @author	박소연
 * @since	2022.06.21
 * @version	v.1.0
 * 
 * 			작업 이력 ]
 * 					2022.06.21 - 담당자 : 박소연
 * 									클래스 제작
 * 
 *
 */

import java.io.*;
public class FileUtil {

	/*
		파일 이름이 중복되면 이전에 업로드한 파일에 덮어쓰기가 된다.
		같은 이름의 파일이 존재하면 파일 이름을 바꿔서 저장해준다.
		이전에 업로드된 동일한 이름의 파일도 유지가 되고
		내가 현재 업로드하는 파일도 저장이 된다.
	*/
	
	//new, bean 불필요
	public static String rename(String path, String oldName) {
		/*
			리네임 정책 설정
				
				같은 이름의 파일이 존재하면 "_숫자"를 붙여서
				이름을 바꾸는 방식을 사용
			
			[예]
				sample.jpg 라는 파일을 업로드하려 하는데
				이미 업로드된 파일의 이름이 존재하면
				=> sample_1.jpg
						로 변경시켜서 저장해준다.
		*/
		
		//동일한 파일이름에 부여될 번호 기억할 변수
		int count = 0;
		
		String newName = oldName;
		File file = new File(path, oldName); //객체 생성
	
		while(file.exists()) {
			//이 경우 이미 newName으로 저장된 파일이 존재하는 경우
			//파일 이름을 다시 만든다..
			count++;
			int len = oldName.lastIndexOf(".");  
			String preName = oldName.substring(0, len); //파일이름
			String ext = oldName.substring(len); //확장자
			
			newName = preName + "_" + count + ext;
			
			file = new File(path, newName);
			
		}

		return newName;
	}
}
