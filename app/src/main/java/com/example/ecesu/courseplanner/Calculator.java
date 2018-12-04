package com.example.ecesu.courseplanner;

public class Calculator {
    double score;
    double weight;
}

public Calculator(double score, double weight)
{
    this.score = score;
    this.weight = weight;
}

public double FinalScore()
{
    return score * weight / 100;
}

public AverageGrade(Calculator [] grades)
{
    double sum = 0;
    for (int i = 0; i < grades.length; i++)
    {
        sum = sum + grades[i].FinalScore();
    }
    return sum / grades.length;
}
