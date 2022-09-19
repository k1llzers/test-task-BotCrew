package com.example.application.service.impl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    private final GettingHeadService gettingHeadService;
    private final StatisticService statisticService;
    private final AverageSalaryService averageSalaryService;
    private final CountOfEmployeeService countOfEmployeeService;
    private final SearchByTemplateService searchByTemplateService;

    public CommandService(GettingHeadService gettingHeadService,
                          StatisticService statisticService,
                          AverageSalaryService averageSalaryService,
                          CountOfEmployeeService countOfEmployeeService,
                          SearchByTemplateService searchByTemplateService) {
        this.gettingHeadService = gettingHeadService;
        this.statisticService = statisticService;
        this.averageSalaryService = averageSalaryService;
        this.countOfEmployeeService = countOfEmployeeService;
        this.searchByTemplateService = searchByTemplateService;
    }

    private String[] getCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a command: ");
        return scanner.nextLine().split(" ");
    }

    private void doCommand(String[] command) {
        switch (command[0]) {
            case "Who": {
                System.out.println("Head of " + command[5] + " department is "
                        + gettingHeadService.getHeadOfDepartment(command[5]).getName());
                processCommand();
                break; }
            case "Show": {
                switch (command[2]) {
                    case "statistics": {
                        System.out.println(statisticService.getStatistic(command[1]));
                        processCommand();
                        break;
                    }
                    case "average": {
                        System.out.println("The average salary of " + command[7] + " is "
                                + averageSalaryService.getAverageSalary(command[7]));
                        processCommand();
                        break;
                    }
                    case "of": {
                        System.out.println(countOfEmployeeService.getCount(command[5]));
                        processCommand();
                        break;
                    }
                    default:
                }
                break;
            }
            case "Global": {
                List<String> lectors = searchByTemplateService.search(command[3])
                        .stream()
                        .map(lector -> lector.getName())
                        .collect(Collectors.toList());
                for (String lector:lectors) {
                    System.out.println(lector);
                }
                processCommand();
                break;
            }
            default: {
            }
        }

    }

    public void processCommand() {
        doCommand(getCommand());
    }
}
