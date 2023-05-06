package com.example.assss13;
public class Question
{
    private int qId;

    private boolean qCorrect;

    public Question(int qId, boolean qCorrect)
    {
        this.qId = qId;
        this.qCorrect = qCorrect;
    }

    public int getqId()
    {
        return qId;
    }

    public void setqId(int qId)
    {
        this.qId = qId;
    }

    public boolean isqCorrect()
    {
        return qCorrect;
    }

    public void setqCorrect(boolean qCorrect)
    {
        this.qCorrect = qCorrect;
    }
}
