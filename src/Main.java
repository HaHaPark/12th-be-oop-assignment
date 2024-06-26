import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentServiceImpl studentServiceImpl = new StudentService();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n### 학생 관리 시스템 ###");
                System.out.println("1. 학생 등록");
                System.out.println("2. 학생 조회");
                System.out.println("3. 전체 학생 조회");
                System.out.println("4. 학생 수정");
                System.out.println("5. 학생 삭제");
                System.out.println("6. 학생 이름으로 검색");
                System.out.println("0. 종료");
                System.out.print("메뉴 선택: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 제거

                switch (choice) {
                    case 1:
                        System.out.print("학생 이름을 입력하세요: ");
                        String name = scanner.nextLine();
                        System.out.print("학생 학번을 입력하세요: ");
                        String studentId = scanner.nextLine();
                        System.out.print("국어 성적을 입력하세요: ");
                        int koreanScore = scanner.nextInt();
                        System.out.print("영어 성적을 입력하세요: ");
                        int englishScore = scanner.nextInt();
                        System.out.print("수학 성적을 입력하세요: ");
                        int mathScore = scanner.nextInt();
                        scanner.nextLine();

                        StudentDTO student = new StudentDTO();
                        student.setName(name);
                        student.setStudentId(studentId);
                        student.setKoreanScore(koreanScore);
                        student.setEnglishScore(englishScore);
                        student.setMathScore(mathScore);

                        studentServiceImpl.addStudent(student);

                        System.out.println("학생이 성공적으로 등록되었습니다.");

                        // 학생 등록 로직
                        break;
                    case 2:

                        System.out.println("모든 학생 정보 조회:");
                        List<StudentDTO> students = studentServiceImpl.getAllStudents();
                        if (students.isEmpty()) {
                            System.out.println("등록된 학생이 없습니다.");
                        } else {
                            for (StudentDTO stu : students) {
                                System.out.println("등록번호: " + stu.getId() +", 학번: " + stu.getStudentId() + ", 이름: " + stu.getName() +
                                        ", 국어 성적: " + stu.getKoreanScore() +
                                        ", 영어 성적: " + stu.getEnglishScore() +
                                        ", 수학 성적: " + stu.getMathScore());
                            }
                        }
                        break;

                    case 3:

                    case 4:
                        // 학생 수정 로직
                        break;
                    case 5:
                        // 학생 삭제 로직
                        break;
                    case 6:
                        // 학생 이름으로 검색
                        break;
                    case 0:
                        System.out.println("시스템을 종료합니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            }
        }
    }
}
