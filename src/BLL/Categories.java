/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ccks
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
    , @NamedQuery(name = "Categories.findByIdcategories", query = "SELECT c FROM Categories c WHERE c.idcategories = :idcategories")
    , @NamedQuery(name = "Categories.findByCategorieName", query = "SELECT c FROM Categories c WHERE c.categorieName = :categorieName")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcategories")
    
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer idcategories;
    @Column(name = "categorie_name")
    private String categorieName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriesIdcategories")
    private Collection<Quiz> quizCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategories")
    private Collection<Questions> questionsCollection;

    public Categories() {
    }

    public Categories(Integer idcategories) {
        this.idcategories = idcategories;
    }

    public Integer getIdcategories() {
        return idcategories;
    }

    public void setIdcategories(Integer idcategories) {
        this.idcategories = idcategories;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    @XmlTransient
    public Collection<Quiz> getQuizCollection() {
        return quizCollection;
    }

    public void setQuizCollection(Collection<Quiz> quizCollection) {
        this.quizCollection = quizCollection;
    }

    @XmlTransient
    public Collection<Questions> getQuestionsCollection() {
        return questionsCollection;
    }

    public void setQuestionsCollection(Collection<Questions> questionsCollection) {
        this.questionsCollection = questionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategories != null ? idcategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.idcategories == null && other.idcategories != null) || (this.idcategories != null && !this.idcategories.equals(other.idcategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return categorieName;
    }
    
}
