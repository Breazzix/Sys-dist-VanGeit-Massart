package io.HEPL.dossierFinalSysDist.models;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private float prix;
    private int nombre_dispo;

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    private int tva;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Article() {
        super();
    }

    public Article(int id, String name, int price, int nb) {
        super();
        this.Id = id;
        this.name = name;
        this.prix = price;
        this.nombre_dispo = nb;
    }

    public Article(String name, float price, int tva) {
        this.name = name;
        this.prix = price;
        this.tva = tva;
    }

    public Article(String name, int price, int nb) {
        super();
        this.name = name;
        this.prix = price;
        this.nombre_dispo = nb;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom_article) {
        this.name = nom_article;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNombre_dispo() {
        return nombre_dispo;
    }

    public void setNombre_dispo(int nombre_dispo) {
        this.nombre_dispo = nombre_dispo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = (int) (prime * result + prix);
        result = prime * result + nombre_dispo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Article other = (Article) obj;

        if (Id != other.Id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (prix != other.prix)
            return false;
        if (nombre_dispo != other.nombre_dispo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + Id + ", name=" + name + ", price=" + prix + ", number=" + nombre_dispo +"]";
    }

}
