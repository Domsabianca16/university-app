package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.Human;
import ro.fasttrackit.university.app.repository.HumanRepository;
import ro.fasttrackit.university.app.repository.dao.HumanEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HumanService {

    private final HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepository){
        this.humanRepository= humanRepository;
    }

    public List<Human> deleteById(Long id) {
        final List<HumanEntity> deletedById = this.humanRepository.findAll()
                .stream()
                .filter(humanEntity -> humanEntity.getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(humanEntity -> this.humanRepository.deleteById(humanEntity.getId()));
        return deletedById.stream()
                .map(humanEntity -> {
                    Human human = new Human();
                    human.setId(humanEntity.getId());
                    human.setCnp(humanEntity.getCnp());
                    human.setFirstName(humanEntity.getFirstName());
                    human.setLastName(humanEntity.getLastName());
                    return human;
                })
                .collect(Collectors.toList());
    }


    public List<Human> getAllHumans(){
        final List<HumanEntity> all = this.humanRepository.findAll();
        return all.stream()
                .map(humanEntity -> {
                    Human createdHuman = new Human();
                    createdHuman.setId(humanEntity.getId());
                    createdHuman.setCnp(humanEntity.getCnp());
                    createdHuman.setFirstName(humanEntity.getFirstName());
                    createdHuman.setLastName(humanEntity.getLastName());
                    return createdHuman;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateHuman(Human toCreate){
        HumanEntity createOrUpdateMe = new HumanEntity();
        createOrUpdateMe.setId(toCreate.getId());
        createOrUpdateMe.setCnp(toCreate.getCnp());
        createOrUpdateMe.setFirstName(toCreate.getFirstName());
        createOrUpdateMe.setLastName(toCreate.getLastName());
        this.humanRepository.save(createOrUpdateMe);


    }
    public List<Human> getHumanById(Long id) {
        final List<HumanEntity> humanById = this.humanRepository.findAll();
        return humanById.stream()
                .filter(humanEntity -> humanEntity.getId().equals(id))
                .map(humanEntity -> {
                    Human human = new Human();
                    human.setId(humanEntity.getId());
                    human.setCnp(humanEntity.getCnp());
                    human.setFirstName(humanEntity.getFirstName());
                    human.setLastName(humanEntity.getLastName());
                    return human;
                })
                .collect(Collectors.toList());
    }



}
