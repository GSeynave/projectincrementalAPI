package com.projectincremental.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectincremental.exceptions.EntityNotFoundException;
import com.projectincremental.models.Caracteristique;
import com.projectincremental.models.Personnage;
import com.projectincremental.models.UserDocument;
import com.projectincremental.models.dtos.Character;
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
	public UserDocument updatePersonnageZone(String username, String nomPersonnage, String nomZone) {

		UserDocument userDocument = findUserByUsernameAndNom(username, nomPersonnage);
		if (!Objects.nonNull(userDocument)) {
			throw new EntityNotFoundException("Aucun personnage " + nomPersonnage + " pour le username " + username);
		}
		userDocument.getPersonnages().forEach(personnage -> {
			if (personnage.getNom().equals(nomPersonnage)) {
				personnage.setNomZone(nomZone);
			}
		});

		return userRepository.save(userDocument);
	}

	@Transactional
	private UserDocument findUserByUsernameAndNom(String username, String nom) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username).and("personnages.nom").is(nom));
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

	@Override
	public UserDocument createCharacters(String username, List<Character> characters) {
		// TODO get caracteristique depending on the classe
		var user = findByUsername(username);
		if (Objects.isNull(user)) {
			throw new EntityNotFoundException(
					new StringBuilder().append("No account with username ").append(username).toString());
		}
		List<Personnage> personnages = new ArrayList<>();
		if (Objects.nonNull(user.getPersonnages())) {
			user.getPersonnages().forEach(personnage -> {
				personnages.add(personnage);
			});
		}
		characters.forEach(character -> {
			Personnage personnage = new Personnage();
			personnage.setNiveau(1l);
			personnage.setNom(character.getCharacterName());
			personnage.setNomZone("Prairie du village");
			personnage.setClasse(character.getClasse());
			personnage.setCaracteristique(initCaracteristique());
			personnages.add(personnage);
		});

		user.setPersonnages(personnages);
		return userRepository.save(user);
	}

	private Caracteristique initCaracteristique() {
		var caracteristique = new Caracteristique();
		caracteristique.setVie(10d);
		caracteristique.setDegat(2d);
		return caracteristique;
	}
}
