package test.map;

import java.util.*;
import java.io.*;

public class StudentManager {

	private ArrayList<Student> list = new ArrayList<Student>();
	private Properties prop = new Properties();
	
	public StudentManager() {}
	
	public void propertyInsert(Student st) { // Student의 객체 st 생성
		prop.setProperty(st.getNo(), st.toString());
		System.out.println(st.getName()+" 학생의 데이터 삽입 성공!");
	}
	
	public void propertyStore() {
		try { // 설정 파일 저장시
			prop.store(new FileWriter(new File("prop.propeties")), "Ex_Student.properties");
			System.out.println("학생 데이터 저장 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void propertyPrint() {
		try { // 설정 파일 불러올시
			prop.load(new FileReader(new File("prop.propeties")));
			
			for(int i=1; i<=prop.size(); i++) {
				String index = String.valueOf(i); // String 형변환을 통한 key값 도출
				list.add(parseStudent(prop.getProperty(index)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Student s : list) {
			System.out.println(s);
			}
			System.out.println("학생 데이터 출력이 완료되었습니다.");
	}
	
	
	
	public Student parseStudent(String str) { // 넘겨 받은 데이터를 학생 객체로 변환
		String tmp[] = str.split(", ");
		return new Student(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
		}

	
	
	
	
	
	
	
	
	
}
