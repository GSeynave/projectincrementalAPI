package com.projectincremental.services.impl;

import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.models.UserDocument;
import com.projectincremental.repositories.UserRepository;
import com.projectincremental.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	public UserServiceImpl(UserRepository userRepository, MongoTemplate mongoTemplate) {
		super();
		this.userRepository = userRepository;
		this.mongoTemplate = mongoTemplate;
	}

	private final UserRepository userRepository;
	private final MongoTemplate mongoTemplate;

    @Override
	public UserDocument findById(String userId) {
		return mongoTemplate.findById(new ObjectId(userId), UserDocument.class);
    }

	@Override
	@Transactional
	public UserDocument updatePersonnageZone(String userId, String nomPersonnage, String nomZone) {

		UserDocument userDocument = findUserByIdAndNom(userId, nomPersonnage);
		if (!Objects.nonNull(userDocument)) {
			throw new EntityNotFoundException("Aucun personnage " + nomPersonnage + " pour le userId " + userId);
		}
		userDocument.getPersonnages().forEach(personnage -> {
			if (personnage.getNom().equals(nomPersonnage)) {
				personnage.setNomZone(nomZone);
			}
		});

		return userRepository.save(userDocument);
	}

	@Transactional
	private UserDocument findUserByIdAndNom(String userId, String nom) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId).and("personnages.nom").is(nom));
		query.limit(1);
		return mongoTemplate.findOne(query, UserDocument.class);
	}

	@Transactional
	public UserDocument findByUsername(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		query.limit(1);
		return mongoTemplate.findOne(query, UserDocument.class);
	}
}
