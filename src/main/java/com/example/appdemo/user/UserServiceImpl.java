package com.example.appdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user)
	{
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);

		Role role = roleRepository.findByRole("ROLE_SYMPATHIZER");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));

		userRepository.save(user);
	}
}
