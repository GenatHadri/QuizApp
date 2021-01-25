/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ccks
 */
@Entity
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
    , @NamedQuery(name = "Quiz.findByIdquiz", query = "SELECT q FROM Quiz q WHERE q.idquiz = :idquiz")
    , @NamedQuery(name = "Quiz.findByQuizName", query = "SELECT q FROM Quiz q WHERE q.quizName = :quizName")
    , @NamedQuery(name = "Quiz.findByCreatedAt", query = "SELECT q FROM Quiz q WHERE q.createdAt = :createdAt")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idquiz")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    
    private Integer idquiz;
    @Column(name = "quiz_name")
    private String quizName;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @JoinColumn(name = "categories_idcategories", referencedColumnName = "idcategories")
    @ManyToOne(optional = false)
    private Categories categoriesIdcategories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizIdquiz")
    private Collection<Results> resultsCollection;

    public Quiz() {
    }

    public Quiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public Integer getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Integer idquiz) {
        this.idquiz = idquiz;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Categories getCategoriesIdcategories() {
        return categoriesIdcategories;
    }

    public void setCategoriesIdcategories(Categories categoriesIdcategories) {
        this.categoriesIdcategories = categoriesIdcategories;
    }

    @XmlTransient
    public Collection<Results> getResultsCollection() {
        return resultsCollection;
    }

    public void setResultsCollection(Collection<Results> resultsCollection) {
        this.resultsCollection = resultsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquiz != null ? idquiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.idquiz == null && other.idquiz != null) || (this.idquiz != null && !this.idquiz.equals(other.idquiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Quiz[ idquiz=" + idquiz + " ]";
    }
    
}
