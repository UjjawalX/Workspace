package model;

public class Work {
    String title;
    int lineNo;
    int noOfOccurrence;
    String body;

    public int getNoOfOccurrence() {
        return noOfOccurrence;
    }

    public void setNoOfOccurrence(int noOfOccurrence) {
        this.noOfOccurrence = noOfOccurrence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
