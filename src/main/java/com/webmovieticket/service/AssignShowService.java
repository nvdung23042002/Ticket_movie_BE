package com.webmovieticket.service;

import com.webmovieticket.dto.AssignShowDTO;
import com.webmovieticket.mapper.AssignShowMapper;
import com.webmovieticket.models.AssignShow;
import com.webmovieticket.repository.AssignShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignShowService {

    @Autowired
    private AssignShowMapper assignShowMapper;

    @Autowired
    private AssignShowRepository assignShowRepository;

    public List<AssignShowDTO> findAll() {
        return assignShowRepository.findAll().stream().map(
                assignShow -> assignShowMapper.returnDTO(assignShow)).collect(Collectors.toList());
    }

    public AssignShowDTO findById(Long show_id) {
        return assignShowMapper.returnDTO(assignShowRepository.findById(show_id)
                .orElseThrow(() -> new RuntimeException()));
    }

    public void addAssignShow(AssignShow assignShow) {
        assignShowRepository.save(assignShow);
    }

    public void updateAssignShow(Long id, AssignShow assignShow) {

        AssignShow oldAssignShow = assignShowRepository.findById(id).orElseGet(() -> null);

        if (oldAssignShow != null) {
            oldAssignShow.setMorning(assignShow.getMorning());
            oldAssignShow.setMatney(assignShow.getMatney());
            oldAssignShow.setFirstShow(assignShow.getFirstShow());
            oldAssignShow.setSecondShow(assignShow.getSecondShow());
            oldAssignShow.setAddShowDate(assignShow.getAddShowDate());
            oldAssignShow.setToDate(assignShow.getToDate());

            assignShowRepository.save(oldAssignShow);
        }
    }

    public void deleteAssignShow(Long id) {
        assignShowRepository.deleteById(id);
    }
}
