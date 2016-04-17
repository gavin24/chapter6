package com.ackerman.j.gavin.zootrack.Domain;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class Food {
    private long id;
    private float price;
    private String name;
    private String type;


    public Food(Builder builder) {
        id=builder.id;
        price=builder.price;
        name=builder.name;
        type=builder.type;

    }

    public long getId() {
        return id;
    }

    public float getprice() {
        return price;
    }

    public String getname() {
        return name;
    }



    public String getType() {
        return type;
    }


    public static class Builder{
        private long id;
        private float price;
        private String name;
        private String type;

        public Builder (long id)
        {
            this.id= id;

        }


        public Builder price(float value){
            this.price=value;
            return this;
        }

        public Builder name(String value){
            this.name=value;
            return this;
        }


        public Builder type(String value){
            this.type=value;
            return this;
        }

        public Builder copy(Food value){
            this.id=value.id;
            this.price=value.price;
            this.name=value.name;

            this.type=value.type;
            return this;
        }

        public Food build(){
            return new Food(this);
        }
    }
}
