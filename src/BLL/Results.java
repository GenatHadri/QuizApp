/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ccks
 */
@Entity
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r")
    , @NamedQuery(name = "Results.findByIdresults", query = "SELECT r FROM Results r WHERE r.idresults = :idresults")
    , @NamedQuery(name = "Results.findByTime", query = "SELECT r FROM Results r WHERE r.time = :time")
    , @NamedQuery(name = "Results.findByCorrectAnswer", query = "SELECT r FROM Results r WHERE r.correctAnswer = :correctAnswer")})
public class Results implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idresults")
    private Integer idresults;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "correct_answer")
    private Integer correctAnswer;
    @JoinColumn(name = "quiz_idquiz", referencedColumnName = "idquiz")
    @ManyToOne(optional = false)
    private Quiz quizIdquiz;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private Users userIduser;

    public Results() {
    }

    public Results(Integer idresults) {
        this.idresults = idresults;
    }

    public Integer getIdresults() {
        return idresults;
    }

    public void setIdresults(Integer idresults) {
        this.idresults = idresults;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Quiz getQuizIdquiz() {
        return quizIdquiz;
    }

    public void setQuizIdquiz(Quiz quizIdquiz) {
        this.quizIdquiz = quizIdquiz;
    }

    public Users getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Users userIduser) {
        this.userIduser = userIduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresults != null ? idresults.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.idresults == null && other.idresults != null) || (this.idresults != null && !this.idresults.equals(other.idresults))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Results[ idresults=" + idresults + " ]";
    }
    
}
