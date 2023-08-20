package com.springdatalearning.spring.data.jpa.tutorial.repository;

import com.springdatalearning.spring.data.jpa.tutorial.entity.Guardian;
import com.springdatalearning.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@DataJpaTest
// Ideally we should be using the above annotation for writing test cases for repositories, so that once test is done, all the changes should get undone.
// But this time we want to impact our database to see what different methods of the repository do. Hence we are using SpringBootTest
@SpringBootTest //With this the changes done to the DB will not be undone
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("deep1@gmail.com")
                .firstName("Deep1")
                .lastName("Kar1")
//                .guardianName("Goutam1")
//                .guardianEmail("goutam1@gmail.com")
//                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
        // Queries executed in the background:
//        Hibernate: select next_val as id_val from student_sequence for update
//        Hibernate: update student_sequence set next_val= ? where next_val=?
//        Hibernate: insert into tbl_student (email_address, first_name, guardian_email, guardian_mobile, guardian_name, last_name, student_id) values (?, ?, ?, ?, ?, ?, ?)
    }

    @Test
    public void saveStudentWithGuardianDetails() {
        Guardian guardian = Guardian.builder()
                .name("Goutam2")
                .email("goutam2@gmail.com")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Deep2")
                .emailId("deep2@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
//        Hibernate: select next_val as id_val from student_sequence for update
//        Hibernate: update student_sequence set next_val= ? where next_val=?
//        Hibernate: insert into tbl_student (email_address, first_name, guardian_email, guardian_mobile, guardian_name, last_name, student_id) values (?, ?, ?, ?, ?, ?, ?)
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.printf("studentList = " + studentList);
//        Hibernate: select student0_.student_id as student_1_0_, student0_.email_address as email_ad2_0_, student0_.first_name as first_na3_0_, student0_.guardian_email as guardian4_0_, student0_.guardian_mobile as guardian5_0_, student0_.guardian_name as guardian6_0_, student0_.last_name as last_nam7_0_ from tbl_student student0_
//        studentList = [Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmaill.com, guardianName=Goutam1, guardianEmail=goutam1@gmail.com, guardianMobile=1234567890)]2023-08-20 11:11:46.374  INFO 24332 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Deep1");

        System.out.println("students = " + students);
//        Hibernate: select student0_.student_id as student_1_0_, student0_.email_address as email_ad2_0_, student0_.first_name as first_na3_0_, student0_.guardian_email as guardian4_0_, student0_.guardian_mobile as guardian5_0_, student0_.guardian_name as guardian6_0_, student0_.last_name as last_nam7_0_ from tbl_student student0_ where student0_.first_name=?
//        students = [Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmaill.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890))]
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("De");

        System.out.println("students = " + students);
//        Hibernate: select student0_.student_id as student_1_0_, student0_.email_address as email_ad2_0_, student0_.first_name as first_na3_0_, student0_.guardian_email as guardian4_0_, student0_.guardian_mobile as guardian5_0_, student0_.guardian_name as guardian6_0_, student0_.last_name as last_nam7_0_ from tbl_student student0_ where student0_.first_name like ? escape ?
//        students = [Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmaill.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890)), Student(studentId=2, firstName=Deep2, lastName=null, emailId=deep2@gmail.com, guardian=Guardian(name=Goutam2, email=goutam2@gmail.com, mobile=9999999999))]
   }

   @Test
   public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Goutam1");

       System.out.println("students = " + students);
//       Hibernate: select student0_.student_id as student_1_0_, student0_.email_address as email_ad2_0_, student0_.first_name as first_na3_0_, student0_.guardian_email as guardian4_0_, student0_.guardian_mobile as guardian5_0_, student0_.guardian_name as guardian6_0_, student0_.last_name as last_nam7_0_ from tbl_student student0_ where student0_.guardian_name=?
//       students = [Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmaill.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890))]
   }

   @Test
   public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("deep1@gmail.com");

       System.out.println("student = " + student);
//       Hibernate: select student0_.student_id as student_1_0_, student0_.email_address as email_ad2_0_, student0_.first_name as first_na3_0_, student0_.guardian_email as guardian4_0_, student0_.guardian_mobile as guardian5_0_, student0_.guardian_name as guardian6_0_, student0_.last_name as last_nam7_0_ from tbl_student student0_ where student0_.email_address=?
//       student = Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmail.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890))
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("deep1@gmail.com");

        System.out.println("firstName = " + firstName);
//        Hibernate: select student0_.first_name as col_0_0_ from tbl_student student0_ where student0_.email_address=?
//        firstName = Deep1
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("deep1@gmail.com");

        System.out.println("student = " + student);
//        Hibernate: select * from tbl_student s where s.email_address = ?
//        student = Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmail.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890))
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("deep1@gmail.com");

        System.out.println("student = " + student);
//        Hibernate: select * from tbl_student s where s.email_address = ?
//        student = Student(studentId=1, firstName=Deep1, lastName=Kar1, emailId=deep1@gmail.com, guardian=Guardian(name=Goutam1, email=goutam1@gmail.com, mobile=1234567890))
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId(
                "Deep3",
                "deep1@gmail.com"
        );
//        Hibernate: update tbl_student set first_name = ? where email_address = ?
    }
}