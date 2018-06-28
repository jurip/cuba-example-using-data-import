package de.diedavids.ddcdit.entity.sales;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s|name")
@Table(name = "DDCDIT_PRODUCT")
@Entity(name = "ddcdit$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 6590520188494047540L;

    @NotNull
    @Column(name = "PRODUCT_ID", nullable = false, unique = true)
    protected String productId;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    protected ProductCategory category;

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }


    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}