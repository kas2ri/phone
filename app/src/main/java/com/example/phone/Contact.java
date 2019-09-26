package com.example.phone;


public class Contact {
    int Id;
    String Item, /*Color, Memory,*/ Qnt, Total;


    // public  void SetId(int id){this.Id=id; }
    //public  int GetId(){return Id;}







            // public  void SetId(int id){this.Id=id; }
            //public  int GetId(){return Id;}

            public void Setitem(String item) {
                this.Item = item;
            }

            public String Getitem() {
                return Item;
            }
            

            public void Setqnt(String qnt) {
                this.Qnt = qnt;
            }

            public String Getqnt() {
                return Qnt;
            }

            public void Settotal(String total) {
                this.Total = total;
            }

            public String Gettotal() {
                return Total;
            }


        }


