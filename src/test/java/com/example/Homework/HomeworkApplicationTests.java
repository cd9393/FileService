package com.example.Homework;

import com.example.Homework.models.File;
import com.example.Homework.models.Folder;
import com.example.Homework.models.User;
import com.example.Homework.repositories.FileRepository;
import com.example.Homework.repositories.FolderRepository;
import com.example.Homework.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createUserAndFolderThenSave() {
		User user = new User("Craig");
		userRepository.save(user);

		Folder folder1 = new Folder("Documents", user);
		folderRepository.save(folder1);

		userRepository.save(user);
	}

	@Test
	public void createFolderAndFileThenSave() {
		User user = new User("Craig");
		userRepository.save(user);

		Folder folder2 = new Folder("Week13_Homework", user);
		folderRepository.save(folder2);

		File file = new File("Homework", "txt", 1234, folder2);
		fileRepository.save(file);

		folder2.addFile(file);
		folderRepository.save(folder2);
	}

}
