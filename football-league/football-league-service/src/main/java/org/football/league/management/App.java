package org.football.league.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
@ComponentScan(basePackages = {"org.football.league.*"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
}
