package org.launchcode.SkillTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@ResponseBody
public class SkillsController {
    String title = "Skills Tracker";
    String initMessage = " Rank these three programming languages, from your most favorite to your least favorite ";
    ArrayList<String> skills = new ArrayList<> (Arrays.asList("Java","Javascript","Typescript"));
    ArrayList<String> ranks = new ArrayList<>(Arrays.asList("My favorite language","My second favorite language","My third favorite language"));


    @GetMapping ("")
    public String intialScreen(){
        String html = "<h1>" + title + "</h1>" +
                "<h2>" + initMessage + "</h2>" +
                "<h3><ol style='color:blue'>" +
                "<li>" + skills.get(0) + "</li>" +
                "<li>" + skills.get(1) + "</li>" +
                "<li>" + skills.get(2) + "</li>" +
                "</ol></h3>";
        return html;
    }

    @PostMapping ("results")
    public String formResults( @RequestParam String skill1,@RequestParam String skill2,@RequestParam String skill3){
        String html =
                "<div style='width:100%;padding:15%'>" +
                    "<h4>" + ranks.get(0) + skill1 + "</h4>" +
                    "<h4>" + ranks.get(1) + skill2 + "</h4>" +
                    "<h4>" + ranks.get(2) + skill3 + "</h4>" +
                "</div>";
        return html;
    }

    @PostMapping ("resultsAlt")
    public String formResultsAlt( @RequestParam String skill1,@RequestParam String skill2,@RequestParam String skill3) {
        String html =
                "<table> " +
                    "<tr>" +
                        "<th>Ranking</th>" +
                        "<th>Programming Language</th>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>" + ranks.get(0) + skill1 + "</td>" +
                        "<td>" + skill1 + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>" + ranks.get(1) + skill1 + "</td>" +
                        "<td>" + skill2 + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>" + ranks.get(2) + skill1 + "</td>" +
                        "<td>" + skill3 + "</td>" +
                    "</tr>" +
                "</table>";
        return html;
    }





    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping ("form")
    public String generateForm(){

        String html =
            "<div style='width:100%;padding:15%'>" +
                "<form action='/resultsAlt' method='post'>" +

                    "<div align='left'>" +
                        "<h2>Name</h2>" +
                        "<input type='text' name='name'><br>" +
                        "<br>" +
                        "<h3 style='color:green'>Most Liked</h3>" +
                        "<select name='skill1'>" +
                            "<option value=" + skills.get(0) + ">" + skills.get(0) + "</option>" +
                            "<option value=" + skills.get(1) + ">" + skills.get(1) + "</option>" +
                            "<option value=" + skills.get(2) + ">" + skills.get(2) + "</option>" +
                        "</select><br>" +

                        "<h3 style='color:goldenrod'>Runner-up</h3>" +
                        "<select name='skill2'>" +
                            "<option value=" + skills.get(0) + ">" + skills.get(0) + "</option>" +
                            "<option value=" + skills.get(1) + ">" + skills.get(1) + "</option>" +
                            "<option value=" + skills.get(2) + ">" + skills.get(2) + "</option>" +
                        "</select><br>" +

                        "<h3 style='color:red'>Least favorite</h3>" +
                        "<select name='skill3'>" +
                            "<option value=" + skills.get(0) + ">" + skills.get(0) + "</option>" +
                            "<option value=" + skills.get(1) + ">" + skills.get(1) + "</option>" +
                            "<option value=" + skills.get(2) + ">" + skills.get(2) + "</option>" +
                        "</select><br>" +
                    "</div>" +

                    "<div align='center'>" +
                        "<input type='submit' value='SUBMIT!' style='background-color:Chartreuse'>" +
                    "</div>" +

                "</form>" +
            "</div>";

        return html;
    }


}
