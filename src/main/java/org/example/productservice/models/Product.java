package org.example.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    String description;
    Double price;
    @ManyToOne
    @JsonIgnore
    Category category;
}


//{
//        "id":13,
//        "title":"Iphone 16",
//        "description" : "Iphone 16 with M2",
//        "price" : 34455.0,
//        "category" : {
//        "id":23,
//        "title":"Electronics"
//        }
//        }
