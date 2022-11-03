package com.webmovieticket.mapper;

import com.webmovieticket.dto.AssignShowDTO;
import com.webmovieticket.models.AssignShow;
import org.springframework.stereotype.Component;

@Component
public class AssignShowMapper {

    public AssignShowDTO returnDTO(AssignShow assignShow) {
        AssignShowDTO assignShowDTO = new AssignShowDTO();

        assignShowDTO.setShow_id(assignShow.getShow_id());
        assignShowDTO.setMorning(assignShow.getMorning());
        assignShowDTO.setMatney(assignShow.getMatney());
        assignShowDTO.setFirstShow(assignShow.getFirstShow());
        assignShowDTO.setSecondShow(assignShow.getSecondShow());
        assignShowDTO.setAddShowDate(assignShow.getAddShowDate());
        assignShowDTO.setToDate(assignShow.getToDate());
        return assignShowDTO;
    }

    public AssignShow returnEntity(AssignShowDTO assignShowDTO) {
        AssignShow assignShow = new AssignShow();

        assignShow.setShow_id(assignShowDTO.getShow_id());
        assignShow.setMorning(assignShowDTO.getMorning());
        assignShow.setMatney(assignShowDTO.getMatney());
        assignShow.setFirstShow(assignShowDTO.getFirstShow());
        assignShow.setSecondShow(assignShowDTO.getSecondShow());
        assignShow.setAddShowDate(assignShowDTO.getAddShowDate());
        assignShow.setToDate(assignShowDTO.getToDate());
        return assignShow;
    }
}
