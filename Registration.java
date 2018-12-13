

      import java.awt.*;
      import java.awt.event.*;


      class Registration extends Frame implements ActionListener{

        Button save,cancel;
        Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
        TextField id,name,dd,yyyy,mm;

        Registration(){

          // setBackground(Color.GRAY);
           setLayout(null);
           setFont(new Font("Dialog",Font.BOLD,14));

           l1 = new Label("Name");
           l2 = new Label("dd");
           l3 = new Label("mm");
           l4 = new Label("yyyy");
           l5 = new Label("email id");
           //l6 = new Label("Publisher");
          /* l7 = new Label("Subject");
           l9 = new Label("Publish Year");
           l8 = new Label("Author Name");*/


           name = new TextField(5);
           dd = new TextField(15);
           mm = new TextField(10);
           yyyy = new TextField(4);
           id = new TextField(4);
         /*  pub = new TextField(15);
           sub = new TextField(10);
           year = new TextField(4);
           author = new TextField(15);*/

           save = new Button("save");
           cancel = new Button("Cancel");

           add(l1);
           l1.setBounds(200,100,120,20);
           add(l2);
           l2.setBounds(200,150,120,20);
           add(l3);
           l3.setBounds(200,200,120,20);
           add(l4);
           l4.setBounds(200,250,120,20);
           add(l5);
           l5.setBounds(200,300,120,20);
          /* add(l6);
           l6.setBounds(200,350,120,20);
           add(l7);
           l7.setBounds(200,400,120,20);
           add(l8);
           l8.setBounds(200,450,120,20);
           add(l9);
           l9.setBounds(200,500,120,20);*/

           add(name);
           name.setBounds(370,100,150,20);
           add(dd);
           dd.setBounds(370,150,150,20);
           add(mm);
           mm.setBounds(370,200,150,20);
           add(yyyy);
           yyyy.setBounds(370,250,150,20);
           add(id);
           id.setBounds(370,300,150,20);
           /*add(pub);
           pub.setBounds(370,350,150,20);
           add(sub);
           sub.setBounds(370,400,150,20);
           add(author);
           author.setBounds(370,450,150,20);
           add(year);
           year.setBounds(370,500,150,20);*/

           add(cancel);
           cancel.setBounds(200,350,80,50);
           add(save);
           save.setBounds(400,350,80,50);

          name.addActionListener(this);
          id.addActionListener(this);
          mm.addActionListener(this);
          yyyy.addActionListener(this);
          dd.addActionListener(this);
        /*  sub.addActionListener(this);
          page.addActionListener(this);
          author.addActionListener(this);
          price.addActionListener(this);*/

          cancel.addActionListener(this);
          save.addActionListener(this);

          }

          public void actionPerformed(ActionEvent ae){

           if(ae.getSource()==cancel)
            setVisible(false);

           if(ae.getSource()==save){

         update1 u = new update1(name.getText(),dd.getText(),mm.getText(),yyyy.getText(),id.getText());
         name.setText("");
         dd.setText("");
         mm.setText("");
         yyyy.setText("");
         id.setText("");
          }
         }
          public static void main(String args[]){

           Registration u = new Registration();
           u.setSize(700,700);
           u.setVisible(true);

          }
          }
