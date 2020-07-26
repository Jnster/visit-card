package ru.jnster.visitcard.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.jnster.visitcard.domain.Education;
import ru.jnster.visitcard.domain.Interest;
import ru.jnster.visitcard.domain.Job;
import ru.jnster.visitcard.domain.Skill;
import ru.jnster.visitcard.repository.EducationRepo;
import ru.jnster.visitcard.repository.InterestRepo;
import ru.jnster.visitcard.repository.JobRepo;
import ru.jnster.visitcard.repository.SkillRepo;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class DataController {

    private EducationRepo educationRepo;
    private InterestRepo interestRepo;
    private JobRepo jobRepo;
    private SkillRepo skillRepo;

    public DataController(EducationRepo educationRepo, InterestRepo interestRepo, JobRepo jobRepo,
        SkillRepo skillRepo) {
        this.educationRepo = educationRepo;
        this.interestRepo = interestRepo;
        this.jobRepo = jobRepo;
        this.skillRepo = skillRepo;
    }

    @GetMapping("jobs")
    public List<Job> getJobs(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Integer size,
                             @RequestParam(required = false, name = "date-from") Date from,
                             @RequestParam(required = false, name = "date-to") Date to) {
        //Постранично, фильтр "от ... до"
        if (from != null && to != null && page != null && size != null) {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Job> jobPage = jobRepo.findAllByStartOrFinishBetween(pageRequest, from, to);
            return jobPage.getContent();
        }

        //Без параметров
        if (from == null && to == null && page == null && size == null) {
            return jobRepo.findAll();
        }

        //Постранично
        if (from != null && to != null && page == null && size == null) {
            return jobRepo.findAllByStartOrFinishBetween(from, to);
        }

        //Фильтр "от"
        if (from != null && to == null && page == null && size == null) {
            return jobRepo.findAllFrom(from);
        }

        //Постранично, фильтр "от"
        if (from != null && to == null && page != null && size != null) {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Job> jobPage = jobRepo.findAllFrom(pageRequest, from);
            return jobPage.getContent();
        }

        //Фильтр "до"
        if (from == null && to != null && page == null && size == null) {
            return jobRepo.findAllTo(to);
        }

        //Постранично, фильтр "до"
        if (from == null && to != null && page != null && size != null) {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Job> jobPage = jobRepo.findAllTo(pageRequest, to);
            return jobPage.getContent();
        }

        //Фильтр "от ... до"
        if (from == null && to == null && page != null && size != null) {
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Job> jobPage = jobRepo.findAll(pageRequest);
            return jobPage.getContent();
        }
        return null;
    }

    @GetMapping("skills")
    public List<Skill> getSkills(@RequestParam(required = false) Integer page,
                                 @RequestParam(required = false) Integer size) {
        if (page == null || size == null) {
            return skillRepo.findAll();
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Skill> skillPage = skillRepo.findAll(pageRequest);
        return skillPage.getContent();
    }

    @GetMapping("interests")
    public List<Interest> getInterests(@RequestParam(required = false) Integer page,
                                       @RequestParam(required = false) Integer size) {
        if (page == null || size == null) {
            return interestRepo.findAll();
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Interest> interestPage = interestRepo.findAll(pageRequest);
        return interestPage.getContent();
    }

    @GetMapping("educations")
    public List<Education> getEducations(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer size) {
        if (page == null || size == null) {
            return educationRepo.findAll();
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Education> educationPage = educationRepo.findAll(pageRequest);
        return educationPage.getContent();
    }
}
