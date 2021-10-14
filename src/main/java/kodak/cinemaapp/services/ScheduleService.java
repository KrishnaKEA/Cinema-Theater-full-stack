package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.ScheduleRepository;

public class ScheduleService {

    ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
}
