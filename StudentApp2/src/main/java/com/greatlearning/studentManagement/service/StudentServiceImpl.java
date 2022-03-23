package com.greatlearning.studentManagement.service;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;

	private Session session;

	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}

	@Transactional
	public List<Student> findAll() {
		List<Student> studentList = session.createQuery("from Student", Student.class).list();
		return studentList;
	}

	@Transactional
	public Student findById(int id) {
		Student student = session.get(Student.class, id);
		return student;
	}

	@Transactional
	public void save(Student theStudent) {
		session.saveOrUpdate(theStudent);
	}

	@Transactional
	public void deleteById(int Id) {
		Student student = session.get(Student.class, Id);
		session.delete(student);
	}

}