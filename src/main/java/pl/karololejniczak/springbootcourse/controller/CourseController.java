package pl.karololejniczak.springbootcourse.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karololejniczak.springbootcourse.model.CourseDTO;
import pl.karololejniczak.springbootcourse.exception.WrongIdException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value = "/course")

public class CourseController {

    private List<CourseDTO> cours = new ArrayList<>();

    @RequestMapping (value = "/create", method = RequestMethod.POST )               //adnotacja REqBody - obiekt przyjdzie w ciele dla tego żadania
    public ResponseEntity<CourseDTO> createCourse (@RequestBody CourseDTO courseDTO)       // <Long> pozwala na zwrócenie odpowiedzi i kodu HTTP
    {
        if(courseDTO.getId()==null|| courseDTO.getId()<0)
            throw new WrongIdException("Zmienna kurs posiada id nullowe lub mniejsze od zera");
        cours.add(courseDTO);
        System.out.println(courseDTO.getName());
        System.out.println(courseDTO.getLenghtInSecond());
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);    //kod 201

    }


    @RequestMapping(value = "/available", method = RequestMethod.GET )
    public ResponseEntity<List<CourseDTO>> getAvailableCourses ()  //bez parametru, tylko zwracanie
    {
        return new ResponseEntity<>(cours, HttpStatus.OK);    //kod 201
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.POST)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id)
    {
        System.out.println("buyCourse");
        return getCourse(id);
    }


    @RequestMapping(value = "buy2", method = RequestMethod.POST)
    public CourseDTO buyCourse2 (@RequestParam(value = "id") Long id)
    {
        System.out.println("buyCourse2");
        return getCourse(id);
    }

    private CourseDTO getCourse(Long id) {
        CourseDTO courseDTO = null;
        for (CourseDTO c : cours) {
            if (c.getId() !=null&&c.getId().equals(id)) {
                courseDTO = c;
                break;
            }
        }
        if (courseDTO == null) {
            // TODO
        }
        return courseDTO;
    }


//    @RequestMapping(value = "/bought", method = RequestMethod.GET )
//   public ResponseEntity<List<CourseDTO>> getBoughtCourses ()  //bez parametru, tylko zwracanie//   {
//        return new ResponseEntity<>(cours, HttpStatus.OK);    //kod 201
//    }

    }