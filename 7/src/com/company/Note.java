package com.company;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String content;
    private String date;
    public Note(String title , String content, String date){
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * getter
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * set title
     * @param title setter
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get content
     * @return content of note
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     * @param content setter
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get date
     * @return date of note
     */
    public String getDate() {
        return date;
    }

    /**
     * set date
     * @param date setter of note date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * override toString
     * @return the string format of note to show in console
     */
    @Override
    public String toString(){
        return "\n"+title + "\t" + date + "\n" + content + "\n";
    }
}
