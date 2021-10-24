package dolphin;



import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


//ù ��° ������
class MainFrame_One extends JFrame implements MouseListener {    
    
    BufferedImage img;                            //ó���̹��� ����
    MainFrame_One() {
        super("����");                     //â�̸�
        
      try {
         File sourcemage = new File(".\\start.jpg");//�ڹ�\GUI\GUI\. �ȿ� �����ϴ� �̹��� �����´�.
         img =ImageIO.read(sourcemage);            //�̹����� ������ img�� ����
      }catch(IOException e) {
         System.out.println("�̹��� ������ ����");         //�̹����� ������ �ܼ� â�� ���� ���  
         
      }
      
      
        this.setVisible(true);// GUI ȭ�鿡 ȣ��
      
      this.setSize(1440,900);                     // frame ������  1440,900
      this.setLocation(0,0);                     // ���α׷��� �����쿡 ��Ÿ���� ��ġ 0, 0
      this.setResizable(true);                  // ���α׷� â�� ũ�� ���� ���
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� ��ư ����
      this.setLayout(null);                     //��ġ�� ��ǥ�� �ϱ� ���� null���� �߰�
      this.getContentPane().setBackground(Color.WHITE);//������ �Ͼ�� �����.
      
      JLabel Ph = new JLabel(new ImageIcon(img));      //�̹����� �󺧿� �ִ´�.
      Ph.setBounds(100, 80, 700, 700);            //�̹����� x��ǥ 100 y��ǥ 80 ũ��� ���� 700 ���� 700 ���� ��� 
      this.add(Ph);                           //�̹����� ���� ���� ȭ�鿡 �߰�                  
      
      
      JLabel lbl = new JLabel("���� �����ϱ� ������");      //���� ���� ����
        lbl.setFont(getFont().deriveFont(50.0f));      //����ũ�⸦ 50���� �Ѵ�.
        lbl.setBounds(900, 350, 600, 50);            //x��ǥ 900 y��ǥ 350�ϰ� ũ�⸦ ���� 600,���� 50
        this.add(lbl);                           //���� ȭ�鿡 �߰�
        lbl.addMouseListener(this);                  //�� Ŭ���� �̺�Ʈ �߻�
        
        
    }
   
    @Override                                   //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseClicked(MouseEvent e) {        
        new MainFrame_Second();                   //���Ⱑ ������ ��ȯ ����
        this.setVisible(false);
    }
    @Override    //���콺 �̺�Ʈ  �������̽� ���� 
    public void mousePressed(MouseEvent e) {/*��������*/}
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseReleased(MouseEvent e) {/*��������*/}
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseEntered(MouseEvent e) {/*��������*/}    
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseExited(MouseEvent e) {/*��������*/}
}//ù ��° ������ ��
 
class MainFrame_Second extends JFrame implements MouseListener, MouseMotionListener {
   
   public static final int YH = 830;
   ImageIcon imgLoudImage; // ���ε� �̹���
   ImageIcon imgSave;       // ���̺� �̹���
   
   ImageIcon auto;
   ImageIcon auto2;
   
   ImageIcon ratation;
   ImageIcon ratation2;
   
   ImageIcon bright;
   ImageIcon bright2;
   
   ImageIcon filter;
   ImageIcon filter2;
   
//----------------------------------------------------------------------------------------------------------------------------------------------------   
   ImageIcon cut;
   ImageIcon cut2;
   ImageIcon cut3;
   ImageIcon cut4;
   ImageIcon cancel;
   ImageIcon cancel2;
//----------------------------------------------------------------------------------------------------------------------------------------------------
   
   ImageIcon resize;
   ImageIcon resize2;
   
   ImageIcon person;
   ImageIcon person2;
   
   ImageIcon food;
   ImageIcon food2;
   
   ImageIcon view;
   ImageIcon view2;
   
   ImageIcon left_rotation;
   ImageIcon right_rotation;
   
   ImageIcon filter_beauty;
   ImageIcon filter_Natural;
   ImageIcon filter_Analog;
   ImageIcon filter_Nature;
   ImageIcon filter_Pastel;

   ImageIcon Home;
   
   String filePath;      // ���� ��� ����
   String filefilter;      // ���� Ȯ���� ����
   static BufferedImage newImage;      // ���ο� �̹���   
 
   static BufferedImage changeImage;
   BufferedImage tempImage;
   
 
   
   BufferedImage cropImage;      // �ڸ� �̹����� �ӽ� ������ �̹��� ����
     
   int w = 720;         // �̹����� �⺻ �ʺ�
   int h = 720;         // �̹����� �⺻ ����

   int cropx=160, cropy=160, cropw=400, croph=400; //�̹��� �ڸ��� �������� �ʺ� ��ǥ 
   boolean cropon = false; // �̹��� �ڸ��Ⱑ ���۵Ǿ����� �����ϴ� ���� 
   Rectangle crp_str_point= new Rectangle(cropx,cropy,10,10);
   Rectangle crp_end_point= new Rectangle(cropx+cropw-10,cropy+croph-10,10,10);

   boolean strDragged=false;
   boolean endDragged=false;
   int offX=0;
   int offY=0;
   
   
   public static final boolean RIGHT = true;   // ������ ȸ���� �˸��� ���� ���� ���
   public static final boolean LEFT = false;   // ���� ȸ���� �˸��� ���� ���
   
   DrawPanel drawPanel1 = new DrawPanel();   // �̹����� �׸� panel
   JPanel Up = new JPanel();
   JPanel Down = new JPanel();
   
   JPanel mainPanel = new JPanel();
   
    JLabel autoL;
    JLabel autoL2;
    
    JLabel ratationL;
    JLabel ratationL2;
    
    JLabel brightL;
    JLabel brightL2;
    
    JLabel filterL;
    JLabel filterL2;
    
    
    JLabel cutL;
    JLabel cutL2;
    JLabel cutL3;
    JLabel cutL4;
    JLabel cancelL;
    
    
    JLabel resizeL;
    JLabel resizeL2;
    
    JLabel personL;
    JLabel personL2;
    
    JLabel foodL;
    JLabel foodL2;
    
    JLabel viewL;
    JLabel viewL2;
    
    JLabel left_rotationL;
    JLabel right_rotationL;
    
    JLabel filter_beautyL;
    JLabel filter_NaturalL;
    JLabel filter_NatureL;
    JLabel filter_PastelL;
    JLabel filter_AnalogL;

    JLabel HomeL;
    
    JSlider Bright_Slider = new JSlider(1,20,11);
    public int Bright_Slider_int=0;
    
    JButton zoom_button = new JButton("������");

   static BufferedImage empty_image2 = null;
   BufferedImage cropped_img = null;
   BufferedImage zoomed_img = null;
   Container c = getContentPane();
   JPanel panel1 = new JPanel();
   JLabel get1 = new JLabel();
   Point image_point_in_class; // // ���콺 Ŭ���� ���� ��ǥ�� �޾ƿ� ����
   static JLabel get2 = new JLabel(); // �ڸ��Ⱑ �� �̹����� display�ϱ� ���� label
   static JLabel get3 = new JLabel(); // �߶��� �̹����� Ȯ���� ���� display�ϱ� ���� label
   Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
   
   int image_clicked_count = 0;
   static int zoom_button_clicked_count = 0;

   static int[][] original_red_value;
   static int[][] original_green_value;
   static int[][] original_blue_value;
   
   JSlider beauty_slider = new JSlider(0, 100, 100);
   
     MainFrame_Second(){
           
      imgLoudImage = new ImageIcon(".\\UpLoud.Png");  //�̹��� ���
      imgSave = new ImageIcon(".\\save.Png");  //�̹��� ���
      
      auto = new ImageIcon(".\\auto.Png");  //�̹��� ���
      auto2 = new ImageIcon(".\\auto2.Png");
      
      ratation = new ImageIcon(".\\ratation.Png");  //�̹��� ���
      ratation2 = new ImageIcon(".\\ratation2.Png");  //�̹��� ���
      
      bright = new ImageIcon(".\\bright.Png");  //�̹��� ���
      bright2 = new ImageIcon(".\\bright2.Png");  //�̹��� ���
   
      filter = new ImageIcon(".\\filter.Png");  //�̹��� ���
      filter2 = new ImageIcon(".\\filter2.Png");  //�̹��� ���

      
      cut = new ImageIcon(".\\cut.png");  //�̹��� ���
      cut2 = new ImageIcon(".\\cut2.png");  //�̹��� ���
      cut3 = new ImageIcon(".\\cut3.png");  //�̹��� ���
      cut4 = new ImageIcon(".\\cut4.png");  //�̹��� ���
      cancel = new ImageIcon(".\\cancel.png");  //�̹��� ���
      cancel2 = new ImageIcon(".\\cancel2.png");  //�̹��� ���
 
      
      resize = new ImageIcon(".\\resize.Png");  //�̹��� ���
      resize2 = new ImageIcon(".\\resize2.Png");  //�̹��� ���
      
      person = new ImageIcon(".\\person.Png");  //�̹��� ���
      person2 = new ImageIcon(".\\person2.Png");  //�̹��� ���
      
      food = new ImageIcon(".\\food.Png");  //�̹��� ���
      food2 = new ImageIcon(".\\food2.Png");  //�̹��� ���
      
      view = new ImageIcon(".\\view.Png");  //�̹��� ���
      view2 = new ImageIcon(".\\view2.Png");  //�̹��� ���
      
      left_rotation = new ImageIcon(".\\left_rotation.Png");  //�̹��� ���
      right_rotation = new ImageIcon(".\\right_rotation.Png");  //�̹��� ���
      
      filter_beauty = new ImageIcon(".\\filter_beauty.Png");  //�̹��� ���
      filter_Natural = new ImageIcon(".\\Natural.Png");  //�̹��� ���   
      filter_Nature = new ImageIcon(".\\Nature.Png");  //�̹��� ���
      filter_Pastel = new ImageIcon(".\\Pastel.Png");  //�̹��� ���
      filter_Analog = new ImageIcon(".\\Analog.Png"); 
      Home = new ImageIcon(".\\Home.Png");  //�̹��� ���
      

      try {
         File empty_image = new File(".\\empty.jpg");
         empty_image2 = ImageIO.read(empty_image);
         
      }catch(IOException e) {
         System.out.println("�̹��� ������ ã�� �� ����");
      }


      
      this.setVisible(true);// GUI ȭ�鿡 ȣ��
      this.setSize(1440,960);                     // frame ������  1440,900
      this.setLocation(0,0);                     // ���α׷��� �����쿡 ��Ÿ���� ��ġ 0, 0
      this.setResizable(true);                  // ���α׷� â�� ũ�� ���� ���
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� ��ư ����
      this.setLayout(null);                     //��ġ�� ��ǥ�� �ϱ� ���� null���� �߰�
      this.getContentPane().setBackground(Color.WHITE);//������ �Ͼ�� �����.
      
      mainPanel.setSize(1440,960);                     // frame ������  1440,900
      mainPanel.setLocation(0,0);                     // ���α׷��� �����쿡 ��Ÿ���� ��ġ 0, 0
      mainPanel.setLayout(null);                     //��ġ�� ��ǥ�� �ϱ� ���� null���� �߰�
      mainPanel.setBackground(Color.WHITE);//������ �Ͼ�� �����.
      this.add(mainPanel);
      
        JLabel LoudInmge = new JLabel("Load Image",imgLoudImage,JLabel.CENTER);
        LoudInmge.setBounds(20, YH, 80, 80);            //x��ǥ 900 y��ǥ 350�ϰ� ũ�⸦ ���� 600,���� 50
        mainPanel.add(LoudInmge);   //���� ȭ�鿡 �߰�
        LoudInmge.addMouseListener(this);   
        
        JLabel Save = new JLabel("Save Image",imgSave,JLabel.CENTER);
        Save.setBounds(1300, YH, 80, 80);            //x��ǥ 900 y��ǥ 350�ϰ� ũ�⸦ ���� 600,���� 50
        mainPanel.add(Save);                           //���� ȭ�鿡 �߰�
        Save.addMouseListener(this);   
      
 
        autoL = new JLabel("auto Image",auto,JLabel.CENTER);//����
        autoL.setBounds(70, 25, 60, 60);            //
        mainPanel.add(autoL);                           //���� ȭ�鿡 �߰�
        autoL.addMouseListener(this);   
        //����  �� ���
        autoL2 = new JLabel("auto2 Image",auto2,JLabel.CENTER);//����
        autoL2.setBounds(70, 25, 60, 60);            //
        mainPanel.add(autoL2);                           //���� ȭ�鿡 �߰�
        autoL2.setVisible(false);
        
        ratationL = new JLabel("ratation Image",ratation,JLabel.CENTER);
        ratationL.setBounds(300, 25, 60, 60);            //
        mainPanel.add(ratationL);                           //���� ȭ�鿡 �߰�
        ratationL.addMouseListener(this);   
        //����  �� ���
        ratationL2 = new JLabel("ratation2 Image",ratation2,JLabel.CENTER);
        ratationL2.setBounds(300, 25, 60, 60);            //
        mainPanel.add(ratationL2);                        //���� ȭ�鿡 �߰�
        ratationL2.setVisible(false);
        
        brightL = new JLabel("bright Image",bright,JLabel.CENTER);
        brightL.setBounds(530, 25, 60, 60);            //
        mainPanel.add(brightL);                           //���� ȭ�鿡 �߰�
        brightL.addMouseListener(this);   
        //����  �� ���
        brightL2 = new JLabel("bright2 Image",bright2,JLabel.CENTER);
        brightL2.setBounds(530, 25, 60, 60);            //
        mainPanel.add(brightL2);                           //���� ȭ�鿡 �߰�
        brightL2.setVisible(false);   
        
        filterL = new JLabel("filter Image",filter,JLabel.CENTER);
        filterL.setBounds(760, 25, 60, 60);            //
        mainPanel.add(filterL);                           //���� ȭ�鿡 �߰�
        filterL.addMouseListener(this);   
        //����  �� ���
        
        filterL2 = new JLabel("filter2 Image",filter2,JLabel.CENTER);
        filterL2.setBounds(760, 25, 60, 60);            //
        mainPanel.add(filterL2);                           //���� ȭ�鿡 �߰�
        filterL2.setVisible(false);   
       
        cutL = new JLabel("cut Image",cut,JLabel.CENTER);
        cutL.setBounds(990, 25, 60, 60);            //
        mainPanel.add(cutL);                           //���� ȭ�鿡 �߰�  
        cutL.addMouseListener(this);
        
        //����  �� ���
        cutL2 = new JLabel("cut2 Image",cut2,JLabel.CENTER);
        cutL2.setBounds(990, 25, 60, 60);            //
        mainPanel.add(cutL2);                           //���� ȭ�鿡 �߰�
        cutL2.setVisible(false); 
        cutL2.addMouseListener(this);
        
        cutL3 = new JLabel("cut3 Image",cut3,JLabel.CENTER);
        cutL3.setBounds(500, YH, 80, 80);            //
        mainPanel.add(cutL3);                           //���� ȭ�鿡 �߰�
        cutL3.setVisible(false); 
        cutL3.addMouseListener(this);
        
        cutL4 = new JLabel("cut4 Image",cut4,JLabel.CENTER);
        cutL4.setBounds(500, YH, 80, 80);            //
        mainPanel.add(cutL4);                           //���� ȭ�鿡 �߰�
        cutL4.setVisible(false); 
        
        
        cancelL = new JLabel("cancel Image",cancel,JLabel.CENTER);
        cancelL.setBounds(800, YH, 80, 80);            //
        mainPanel.add(cancelL);                           //���� ȭ�鿡 �߰�
        cancelL.setVisible(false); 
        cancelL.addMouseListener(this);
        
        

        
        resizeL = new JLabel("resize Image",resize,JLabel.CENTER);
        resizeL.setBounds(1210, 25, 60, 60);            //
        mainPanel.add(resizeL);                           //���� ȭ�鿡 �߰�
        resizeL.addMouseListener(this);   
        //����  �� ���
        resizeL2 = new JLabel("resize2 Image",resize2,JLabel.CENTER);
        resizeL2.setBounds(1210, 25, 60, 60);            //
        mainPanel.add(resizeL2);                           //���� ȭ�鿡 �߰�
        resizeL2.setVisible(false);
        
        // ��Ƽ����: Ŭ���� ���콺 ��ǥ���� ����.
        //RemoveMouse listener2 = new RemoveMouse();
        //drawPanel1.addMouseListener(listener2); // (�ڵ� �� ���ư�.)
        
        zoom_button.setSize(150,80);   // �ҷ����� ��ư ������  120, 50
        zoom_button.setLocation(500, YH);   // ��ư ��ġ 1300, 80
        
       
        ActionListener eventHandler = new ActionListener() { // zoom_button�� ���� �̺�Ʈ �ڵ鷯

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            if(e.getSource() == zoom_button) { // zoom_button�� ������
               
               MainFrame_Second.zoom_button_clicked_count++;
               
               if (MainFrame_Second.zoom_button_clicked_count % 2 == 1) {
                  zoom_button.setText("������ �����ϱ�");
                  setCursor(CROSSHAIR_CURSOR); // Ŀ�� ��� ����
                  
                           
               }         
               else if (MainFrame_Second.zoom_button_clicked_count % 2 == 0) {
                  zoom_button.setText("������");
                  setCursor(DEFAULT_CURSOR); // Ŀ�� ����� ������� ����
                  get2.setVisible(true);
                  get3.setVisible(true);
               }
            }
         }
      };
      zoom_button.addActionListener(eventHandler);
      mainPanel.add(zoom_button);
      zoom_button.setVisible(false);
        
      MyActionListener listener = new MyActionListener();
      drawPanel1.addMouseListener(listener);
        
      cropped_img =empty_image2;
        
      get2.setIcon(new ImageIcon(cropped_img));
      get2.setBounds(1250, 300, 60, 60);
      mainPanel.add(get2);
      get2.setVisible(false);
      
      zoomed_img = empty_image2;
      
      get3.setIcon(new ImageIcon(zoomed_img));
      get3.setBounds(1200, 300, 300, 300); 
      mainPanel.add(get3);
      get3.setVisible(false);
      

      
        
        personL = new JLabel("person Image",person,JLabel.CENTER);
        personL.setBounds(300, YH, 90, 90);            //
        mainPanel.add(personL);                           //���� ȭ�鿡 �߰�
        personL.addMouseListener(this);
        personL.setVisible(false);
        //����  �� ���
        personL2 = new JLabel("person2 Image",person2,JLabel.CENTER);
        personL2.setBounds(300, YH, 90, 90);            //
        mainPanel.add(personL2);                           //���� ȭ�鿡 �߰�
        personL2.setVisible(false);
        
        foodL = new JLabel("food Image",food,JLabel.CENTER);
        foodL.setBounds(650, YH, 90, 90);            //
        mainPanel.add(foodL);                           //���� ȭ�鿡 �߰�
        foodL.addMouseListener(this);
        foodL.setVisible(false);
        //����  �� ���
        foodL2 = new JLabel("food2 Image",food2,JLabel.CENTER);
        foodL2.setBounds(650, YH, 90, 90);            //
        mainPanel.add(foodL2);                           //���� ȭ�鿡 �߰�
        foodL2.setVisible(false);
        
        viewL = new JLabel("view Image",view,JLabel.CENTER);
        viewL.setBounds(1000, YH, 90, 90);            //
        mainPanel.add(viewL);                           //���� ȭ�鿡 �߰�
        viewL.addMouseListener(this);
        viewL.setVisible(false);
        //����  �� ���
        viewL2 = new JLabel("view2 Image",view2,JLabel.CENTER);
        viewL2.setBounds(1000, YH, 90, 90);            //
        mainPanel.add(viewL2);                           //���� ȭ�鿡 �߰�
        viewL2.setVisible(false);
        
        left_rotationL = new JLabel("left_rotation Image",left_rotation,JLabel.CENTER);
        left_rotationL.setBounds(500, YH, 90, 90);            //
        mainPanel.add(left_rotationL);                           //���� ȭ�鿡 �߰�
        left_rotationL.addMouseListener(this);
        left_rotationL.setVisible(false);
        
        right_rotationL = new JLabel("right_rotation Image",right_rotation,JLabel.CENTER);
        right_rotationL.setBounds(800, YH, 90, 90);            //
        mainPanel.add(right_rotationL);                           //���� ȭ�鿡 �߰�
        right_rotationL.addMouseListener(this);
        right_rotationL.setVisible(false);
        
        filter_beautyL = new JLabel("filter_beauty Image",filter_beauty,JLabel.CENTER);
        filter_beautyL.setBounds(300, YH, 80, 80);            //
        mainPanel.add(filter_beautyL);     
        filter_beautyL.addMouseListener(this);//���� ȭ�鿡 �߰�
        filter_beautyL.setVisible(false);
        
        filter_NaturalL = new JLabel("filter_Natural Image",filter_Natural,JLabel.CENTER);
        filter_NaturalL.setBounds(500, YH, 80, 80);            //
        mainPanel.add(filter_NaturalL);                           //���� ȭ�鿡 �߰�
        filter_NaturalL.setVisible(false);
        filter_NaturalL.addMouseListener(this);
        
        filter_NatureL = new JLabel("filter_Nature Image",filter_Nature,JLabel.CENTER);
        filter_NatureL.setBounds(700, YH, 80, 80);            //
        mainPanel.add(filter_NatureL);                           //���� ȭ�鿡 �߰�
        filter_NatureL.setVisible(false);
        filter_NatureL.addMouseListener(this);
        
        filter_PastelL = new JLabel("filter_Pastel Image",filter_Pastel,JLabel.CENTER);
        filter_PastelL.setBounds(900, YH, 80, 80);            //
        mainPanel.add(filter_PastelL);                           //���� ȭ�鿡 �߰�
        filter_PastelL.setVisible(false);
        filter_PastelL.addMouseListener(this);
        
        filter_AnalogL = new JLabel("filter_Analog Image",filter_Analog,JLabel.CENTER);
        filter_AnalogL.setBounds(1100, YH, 80, 80);            //
        mainPanel.add(filter_AnalogL);                           //���� ȭ�鿡 �߰�
        filter_AnalogL.setVisible(false);
        filter_AnalogL.addMouseListener(this);
        
        HomeL = new JLabel("Home Image",Home,JLabel.CENTER);
        HomeL.setBounds(10, 720, 100, 80);            //
        mainPanel.add(HomeL);                           //���� ȭ�鿡 �߰�
       
        HomeL.addMouseListener(this);
        
        

        //�ϴ� ��ư �� �����̴�  
       // Bright_Slider.setPaintTicks(true);//�����̴� ���� ���
       // Bright_Slider.setPaintTrack(true);     
        Bright_Slider.setLocation(200, YH);//�����̴� ��ġ
        Bright_Slider.setSize(1000,100);    //�����̴� ���� ����1000 ���� ���� 100
        Bright_Slider.addChangeListener(new BrightnessListener());
        mainPanel.add(Bright_Slider);
        Bright_Slider.setVisible(false);

        beauty_slider.setPaintLabels(true);//�����̴��� �ϴ��� ���� ���
        beauty_slider.setPaintTicks(true);//�����̴� ���� ���
        beauty_slider.setPaintTrack(true);
        beauty_slider.setMajorTickSpacing(5);//20�� ���� ǥ��
        beauty_slider.setMinorTickSpacing(5);//������ 5�� ����
        beauty_slider.setLocation(290, YH);//�����̴� ��ġ
        beauty_slider.setSize(900,100);    
        beauty_slider.addChangeListener(new BeautySliderListener());
        beauty_slider.setVisible(false);
        mainPanel.add(beauty_slider);
        
      drawPanel1.setLocation(350,100);   // ��ο� ��� 1 ��ġ  20 80
      drawPanel1.setSize(720,720);      // ��ο� ��� 1 ������ 720 720
      drawPanel1.addMouseListener(this);
      drawPanel1.addMouseMotionListener(this);
      mainPanel.add(drawPanel1);

      Up.setLocation(0,0);   // ��ο� ��� 1 ��ġ  20 80
      Up.setSize(1440,100);      // ��ο� ��� 1 ������ 720 720
      Up.setBackground(new Color(220,220,220));   // ��ο� ��� ���� 35, 35, 35
      mainPanel.add(Up);
      
      Down.setLocation(0,820);   // ��ο� ��� 1 ��ġ  20 80
      Down.setSize(1440,100);      // ��ο� ��� 1 ������ 720 720
      Down.setBackground(new Color(220,220,220));   // ��ο� ��� ���� 35, 35, 35
      mainPanel.add(Down);
      

      
      
   }

     class DrawPanel extends JPanel{      // DRAWPANEL ���� CLASS 

             public void paintComponent(Graphics g) {
                super.paintComponent(g);         // ���� ������Ʈ ����� ��ȭ�� �ְ� ���� ��  �ۼ� �� �ؿ� �ڵ� �ۼ�
                Graphics2D g2 = (Graphics2D)g;
                g2.drawImage(changeImage, 0, 0, null);      // ����� �̹����� �׷���.\
                if(cropon==true)
                {
                   g2.setColor(Color.red);         // g2�� red
                 g2.drawRect(cropx, cropy, cropw, croph); 
                 g2.fillRect(crp_str_point.x, crp_str_point.y, crp_str_point.width, crp_str_point.height); 
                 g2.fillRect(crp_end_point.x, crp_end_point.y, crp_end_point.width, crp_end_point.height); 
                }

             }
       }

                                      
        //���콺 �̺�Ʈ  �������̽� ���� 
       public void mouseClicked(MouseEvent e) {  
          
          
          if (MainFrame_Second.zoom_button_clicked_count % 2 == 1) {
            return;
         }   
          
    
          autoL2.setVisible(false);
          ratationL2.setVisible(false);
         brightL2.setVisible(false);
         filterL2.setVisible(false);
         
         cutL2.setVisible(false);
         cutL3.setVisible(false); 
         cutL4.setVisible(false);
         cancelL.setVisible(false); 

         zoom_button.setVisible(false);
         get2.setVisible(false);
         get3.setVisible(false);
         resizeL2.setVisible(false);
   
         personL.setVisible(false);
         personL2.setVisible(false);
         
         foodL.setVisible(false);
         foodL2.setVisible(false);
         
         viewL.setVisible(false);
         viewL2.setVisible(false);
         
         left_rotationL.setVisible(false);
         right_rotationL.setVisible(false);
         
         filter_beautyL.setVisible(false);
         filter_NaturalL.setVisible(false);
         filter_NatureL.setVisible(false);
         filter_AnalogL.setVisible(false);
         filter_PastelL.setVisible(false);
         
         Bright_Slider.setVisible(false);
         
         beauty_slider.setVisible(false);
         
         cropon=false;
         
             
         
         JFileChooser chooser = new JFileChooser();      // ���� �����ڸ� �����.


         JLabel myButton = (JLabel)e.getSource();      // ��ư���� �߻��� �̺�Ʈ�� mybutton�� ��´�.
         String temp = myButton.getText();      // �̺�Ʈ�� �߻��� ��ư�� �̸��� ���ڿ� ���·� temp�� ��´�.
         if(temp.equals("Load Image")) {         // ���� ���� ��ư�� �����ҷ�������
            
            FileNameExtensionFilter JPEGfilter = new FileNameExtensionFilter("JPEG(*.jpeg, *.jpg)", "jpg", "jpeg");   // jpg, jpegȮ���ڸ��� ã�� JPG&GIF ImagesȮ���� ���͸� �����.
            FileNameExtensionFilter PNGfilter = new FileNameExtensionFilter("PNG(*.png)", "png");   // png Ȯ���ڸ��� ã�� PNG ImagesȮ���� ���͸� �����.
            FileNameExtensionFilter BMPfilter = new FileNameExtensionFilter("BMP(*.bmp)", "bmp");   // bmp Ȯ���ڸ��� ã�� BMP ImagesȮ���� ���͸� �����.
            chooser.setFileFilter(JPEGfilter);   //���� �����ڿ� ���͸� �ִ´�.
            chooser.setFileFilter(PNGfilter);   //���� �����ڿ� ���͸� �ִ´�.
            chooser.setFileFilter(BMPfilter);   //���� �����ڿ� ���͸� �ִ´�.

            int ret = chooser.showOpenDialog(null);   // ���� ������(����)���� Ȯ���� �������� ���θ� ret�� ��´�.
            if(ret!= JFileChooser.APPROVE_OPTION) {   // ��θ� �������� �ʾ��� ���
               JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);   // ��θ� �������� ���� ��� ��� �׸��� ��Ÿ���� �޼����� ����Ѵ�. 
               return;

            }   
            filePath=chooser.getSelectedFile().getPath();   // filePath�� ���õ� ������ ��� �����͸� ��´�.


            try {

               Image resizeImage;               // 
               BufferedImage image;            // �̹������� image�� �����.
               File input = new File(filePath);   // input�� ���ϰ�ο��� ������ ������ ��´�.
               image = ImageIO.read(input);      // image �̹��� ���ۿ� ���� ��ο��� �о�� �̹��� ������ ��´�.
               resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);   // �̹����� 520 760 ����� �°� ǰ���� ������Ű�鼭 ũ�� ��ȯ�� ���� resizeImage�� ��´�.
               newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);      // newImage�� ���ο� ���� (720 720 ������ RGB)�� �����.
               Graphics g = newImage.getGraphics(); // ���ο� �̹��������� �׸��� ���� g�� ��´�. 
               g.drawImage(resizeImage, 0, 0, null); // �׸��� ���� g�� resizeImage�� 0,0 ���� �׸���.
               g.dispose(); // ���ҽ� ����
               
               //Bright_Slider_int++;


            } catch (IOException e1) {             // ����� ���� �߻� ��
               // TODO Auto-generated catch block
               e1.printStackTrace();            // ������ ���������� ��� 
            }
            changeImage= new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            changeImage=deepCopy(newImage);
            
            tempImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            tempImage=deepCopy(newImage);
            
            
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����
            }
         else if(temp.equals("Save Image")) {
            FileNameExtensionFilter JPEGfilter = new FileNameExtensionFilter("JPEG(*.jpeg, *.jpg)", "jpg", "jpeg");   // jpg, jpegȮ���ڸ��� ã�� JPG&GIF ImagesȮ���� ���͸� �����.
            FileNameExtensionFilter PNGfilter = new FileNameExtensionFilter("PNG(*.png)", "png");   // png Ȯ���ڸ��� ã�� PNG ImagesȮ���� ���͸� �����.
            FileNameExtensionFilter BMPfilter = new FileNameExtensionFilter("BMP(*.bmp)", "bmp");   // bmp Ȯ���ڸ��� ã�� BMP ImagesȮ���� ���͸� �����.
            chooser.setFileFilter(JPEGfilter);   //���� �����ڿ� ���͸� �ִ´�.
            chooser.setFileFilter(PNGfilter);   //���� �����ڿ� ���͸� �ִ´�.
            chooser.setFileFilter(BMPfilter);
            int ret = chooser.showSaveDialog(null);      // ���� ���� ������ â�� ���
            if(ret!= JFileChooser.APPROVE_OPTION) {   // ��θ� �������� �ʾ��� ���
               JOptionPane.showMessageDialog(null, "��θ� �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);   // ��θ� �������� ���� ��� ��� �׸��� ��Ÿ���� �޼����� ����Ѵ�. 
               return;

            }
            filePath=chooser.getSelectedFile().getPath();   // filePath�� ���õ� ������ ��� �����͸� ��´�.
            filefilter=chooser.getFileFilter().getDescription();   // filefilter���� ������ Ȯ���ڸ� ����


            try {
               if(filefilter.equals("JPEG(*.jpeg, *.jpg)")) {      // JPEG�� ������ ���
                  filefilter=".jpeg";                        // Ȯ���ڸ� JPEG�� ����
                  File output = new File(filePath+filefilter);   // ���� ��θ� ���� ���� output ����
                  ImageIO.write(changeImage, "jpeg", output);      // newImage�� jpeg�������� ����
               }
               else if(filefilter.equals("PNG(*.png)")) {         // PNG�� ������ ���
                  filefilter=".png";                        // Ȯ���ڸ� JPEG�� ����
                  File output = new File(filePath+filefilter);   // ���� ��θ� ���� ���� output ����
                  ImageIO.write(changeImage, "png", output);         // newImage�� png�������� ����
               }

               
            } catch (IOException e1) {             // ����� ���� �߻� ��
               // TODO Auto-generated catch block
               e1.printStackTrace();            // ������ ���������� ��� 
            }
         }else if(temp.equals("auto Image")) {
            
            autoL2.setVisible(true);
            personL.setVisible(true);
            foodL.setVisible(true);
            viewL.setVisible(true);


            
         }else if(temp.equals("ratation Image")) {
            
            ratationL2.setVisible(true);
            left_rotationL.setVisible(true);
            right_rotationL.setVisible(true);
            
            
         }else if(temp.equals("left_rotation Image")) {
            
            ratationL2.setVisible(true);
            left_rotationL.setVisible(true);
            right_rotationL.setVisible(true);
            
            
            changeImage = rotation(changeImage, RIGHT);            // �̹��� ȸ�� �޼ҵ� ȣ��
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����
            drawPanel1.repaint();
         }else if(temp.equals("right_rotation Image")) {
            
            ratationL2.setVisible(true);
            left_rotationL.setVisible(true);
            right_rotationL.setVisible(true);
            
            changeImage = rotation(changeImage, LEFT);            // �̹��� ȸ�� �޼ҵ� ȣ��
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����
            drawPanel1.repaint();
            
         }else if(temp.equals("bright Image")) {
            
            brightL2.setVisible(true);
            Bright_Slider.setVisible(true);
            
            
         }else if(temp.equals("filter Image")) {
            

             filterL2.setVisible(true);
             filter_beautyL.setBounds(300, YH, 80, 80);   
             filter_beautyL.setVisible(true);
             filter_NaturalL.setVisible(true);
             filter_NatureL.setVisible(true);
             filter_PastelL.setVisible(true);
             filter_AnalogL.setVisible(true);

         
            
            
         }else if(temp.equals("filter_beauty Image")) {
            
        	 filterL2.setVisible(true);
             filter_beautyL.setBounds(150, YH, 80, 80);     
             filter_beautyL.setVisible(true);
             beauty_slider.setVisible(true);
             
             int width = changeImage.getWidth();
            int height = changeImage.getHeight();
             
           original_red_value = new int[width][height];
          original_green_value = new int[width][height];
          original_blue_value = new int[width][height];
      
          for (int x = 0; x < changeImage.getWidth(); x++) {
               for (int y = 0; y < changeImage.getHeight(); y++) 
                   {
                      Color color = new Color(changeImage.getRGB(x, y));
                      int r, g, b;
                      
                  
                      original_red_value[x][y] = color.getRed();
                      original_green_value[x][y] = color.getGreen();
                       original_blue_value[x][y] = color.getBlue();
                       
                      
                      // beauty���ʹ� �̹����� ���������� ���� ���� ���� ���̱� ������ g, b�� �״�� ���ΰ� r���� ���а� ������ ����.
                      r = checkColorRange(color.getRed() + 40); // �ִ� 40������ ���ϵ��� ����. �� �̻� ���ϸ� �̻���.
                      g = checkColorRange(color.getGreen());
                      b = checkColorRange(color.getBlue());
           
                      color = new Color(r, g, b);
                      changeImage.setRGB(x, y, color.getRGB());
                     
                      
                       repaint();
                   }
             }
             
       
         }else if(temp.equals("cut Image")) {
             
            cutL2.setVisible(true);
            cutL3.setVisible(true); 
            cancelL.setVisible(true); 
              
             cropon=true;
             cropx=160; cropy=160; cropw=400; croph=400; //�̹��� �ڸ��� �������� �ʺ� ��ǥ 
             crp_str_point.x = cropx;
             crp_str_point.y = cropy;
             crp_end_point.x = cropx+cropw-10;
             crp_end_point.y = cropy+croph-10;
            
         
         }else if(temp.equals("cut3 Image")) {
             
            cutL2.setVisible(true);
            cutL4.setVisible(true); 
            cancelL.setVisible(true);
            
            cropImage=new BufferedImage(cropw, croph, BufferedImage.TYPE_INT_RGB);
             cropImage=crop(changeImage,cropx,cropy,cropw,croph);
             changeImage=new BufferedImage(cropw, croph, BufferedImage.TYPE_INT_RGB);
             changeImage=cropImage;
             Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
             g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
             g4.dispose(); // ���ҽ� ����
             drawPanel1.repaint();

                   
         }else if(temp.equals("cancel Image")) {
             
            drawPanel1.repaint();

             
           
         }else if(temp.equals("resize Image")) {

             resizeL2.setVisible(true);
             zoom_button.setVisible(true);
             get2.setVisible(true);
             get3.setVisible(true);
             // ������
            
            
         }else if(temp.equals("person Image")) {
            
            autoL2.setVisible(true);
             personL2.setVisible(true);
             foodL.setVisible(true);
             viewL.setVisible(true);
            
            changeImage = fiter(changeImage,10,10,-1);            // ���Ϳ� 1,1,-8��  �ִ´�.
            changeImage = fiter(changeImage,10,10,-1);            // ���Ϳ� 1,1,-8��  �ִ´�.
            changeImage = filter2(changeImage);            // ���Ϳ� 1,1,-8��  �ִ´�.
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����s
               
            
         }else if(temp.equals("food Image")) {
            
            autoL2.setVisible(true);
            personL.setVisible(true);
            foodL2.setVisible(true);
            viewL.setVisible(true);
            
            changeImage = filter3(changeImage);
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����
            
                    
              
         }else if(temp.equals("view Image")) {
            
            autoL2.setVisible(true);
            personL.setVisible(true);
            foodL.setVisible(true);
            viewL2.setVisible(true);
            
            changeImage = filter1(changeImage);
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
            g4.dispose(); // ���ҽ� ����
            
 
            
         }else if(temp.equals("filter_Pastel Image")) {
             
            filterL2.setVisible(true);
             filter_beautyL.setVisible(true);
             filter_NaturalL.setVisible(true);
             filter_NatureL.setVisible(true);
             filter_PastelL.setVisible(true);
             filter_AnalogL.setVisible(true);
          
             changeImage = fiter(changeImage,1,1,-7);            // ���Ϳ� 1,1,-8��  �ִ´�.
             Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
             g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
             g4.dispose(); // ���ҽ� ����
            
             
          }else if(temp.equals("filter_Natural Image")) {
              
              filterL2.setVisible(true);
              filter_beautyL.setVisible(true);
              filter_NaturalL.setVisible(true);
              filter_NatureL.setVisible(true);
              filter_AnalogL.setVisible(true);
              filter_PastelL.setVisible(true);
              
              
              changeImage = filter7(changeImage);
              Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
              g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
              g4.dispose(); // ���ҽ� ����
              
           }else if(temp.equals("filter_Nature Image")) {
               
               filterL2.setVisible(true);
               filter_beautyL.setVisible(true);
               filter_NaturalL.setVisible(true);
               filter_NatureL.setVisible(true);
               filter_AnalogL.setVisible(true);
               filter_PastelL.setVisible(true);
               
               
               changeImage = filter4(changeImage);
               Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
               g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
               g4.dispose(); // ���ҽ� ����
               
            }else if(temp.equals("filter_Analog Image")) {
                
                filterL2.setVisible(true);
                filter_beautyL.setVisible(true);
                filter_NaturalL.setVisible(true);
                filter_NatureL.setVisible(true);
                filter_AnalogL.setVisible(true);
                filter_PastelL.setVisible(true);
                
                
                changeImage = filter6(changeImage);
                Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
                g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
                g4.dispose(); // ���ҽ� ����
                
             }else if(temp.equals("Home Image")) {
              
              changeImage=deepCopy(newImage);
               Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4�� ��ο��ҳ�1�� �׸��� ������ �ش�.
               g4.drawImage(changeImage, 0, 0, null);               // defaultImage�� ���� �׸���. 
               g4.dispose(); // ���ҽ� ����
               
            }
         
         
         
         if(Bright_Slider_int > 0) {
        	  tempImage=deepCopy(changeImage);//��� ���� �� image ������Ʈ
         }
        
       
         
            
       }

    
       public BufferedImage fiter (BufferedImage buffImage,int corner, int edge,int identity){//���� �Լ�
            final float[] IDENTITY = {0, 0, 0,
                                      0, 1, 0,
                                      0, 0, 0};

            final float[] EDGE = {0, 1, 0,
                                  1, 0, 1,
                                  0, 1, 0};

            final float[] CORNER = {1, 0, 1,
                                    0, 0, 0,
                                    1, 0, 1};
           
            float[] kernel = new float[9];
            int sum = corner * 4 + edge * 4 + identity;
            if (sum == 0) sum = 1;
            for (int i = 0; i < 9; i++) {
                kernel[i] = (corner * CORNER[i] + edge * EDGE[i] + identity * IDENTITY[i]) / sum;
            }
            Kernel a = new Kernel(3, 3, kernel);
            BufferedImageOp convolve = new ConvolveOp(a);
            buffImage = convolve.filter(buffImage, null);
           
           
         
         return buffImage;
      }   
       
          
       public BufferedImage rotation(BufferedImage bi, boolean rotate){   // �̹��� ȸ�� �޼ҵ�
          
         BufferedImage tempimage = new BufferedImage(bi.getHeight(), bi.getWidth(), BufferedImage.TYPE_INT_RGB);      //tempimage�� ���ο� ���� (720 720 ������ RGB)�� �����.
         if(rotate==LEFT)   // ���� 90 ȸ��
         {
            for(int i=0; i<bi.getWidth(); i++)
                  for(int j=0; j<bi.getHeight(); j++)
                      tempimage.setRGB(bi.getHeight()-1-j, i, bi.getRGB(i, j));   // ���� �̹���(bi)�� ���������� 90�� ȸ��
         }
         else if(rotate==RIGHT)   // ������ 90 ȸ��
         {
            for(int i=0; i<bi.getWidth(); i++)
                  for(int j=0; j<bi.getHeight(); j++)
                      tempimage.setRGB(j, bi.getWidth()-1-i, bi.getRGB(i, j));   // ���� �̹���(bi)�� ���������� 90�� ȸ��
         }
         return tempimage;
      }
       public BufferedImage filter1(BufferedImage bi) {
          int[][] red;
          int[][] green;
          int[][] blue;
          int width = bi.getWidth();
            int height = bi.getHeight();
         
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
            int rd=1;
            int gr=1;
            int bl=1;
            int br=1;
            BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
          for (int x = 0; x < bi.getWidth(); x++) {
              for (int y = 0; y < bi.getHeight(); y++) 
                  {
                     Color color = new Color(bi.getRGB(x, y));
                     int r, g, b;
                     
                 
                     red[x][y] = color.getRed();
                     green[x][y] = color.getGreen();
                     blue[x][y] = color.getBlue();
                      
                     if((green[x][y]>red[x][y])&&(blue[x][y]>red[x][y])) {
                        rd=-1;
                        gr=1;
                        bl=1;
                     }else if((blue[x][y]>green[x][y])&&(red[x][y]>green[x][y])){
                        rd=1;
                        gr=-1;
                        bl=1;
                     }else if((red[x][y]>blue[x][y])&&(green[x][y]>blue[x][y])){
                        rd=1;
                        gr=1;
                        bl=-1;
                     }else if((red[x][y]>green[x][y])&&(red[x][y]>blue[x][y])){
                        rd=1;
                        gr=-1;
                        bl=-1;
                     }else if((green[x][y]>red[x][y])&&(green[x][y]>blue[x][y])){
                        rd=1;
                        gr=-1;
                        bl=1;
                     }else if((blue[x][y]>red[x][y])&&(blue[x][y]>green[x][y])){
                        rd=-1;
                        gr=1;
                        bl=1;
                     }else{
                        rd=1;
                        gr=1;
                        bl=1;
                     }
                     
                     if((red[x][y]+green[x][y]+blue[x][y])>382)
                        br=1;
                     else
                        br=-1;
                        
                     
                     
                     r = checkColorRange(color.getRed() + (10*br) + (5*rd));
                     g = checkColorRange(color.getGreen() + (10*br) + (5*gr));
                     b = checkColorRange(color.getBlue() + (10*br) + (5*bl));
          
                     color = new Color(r, g, b);
                     tempimage.setRGB(x, y, color.getRGB());
                    
                     
                  }
            }
          return tempimage;
       }
       public BufferedImage filter2(BufferedImage bi) {
          int[][] red;
          int[][] green;
          int[][] blue;
          int width = bi.getWidth();
            int height = bi.getHeight();
         
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
            
         int br=1;
            BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
          for (int x = 0; x < bi.getWidth(); x++) {
              for (int y = 0; y < bi.getHeight(); y++) 
                  {
                     Color color = new Color(bi.getRGB(x, y));
                     int r, g, b;
                 
                     red[x][y] = color.getRed();
                     green[x][y] = color.getGreen();
                     blue[x][y] = color.getBlue();
                      

                     r = checkColorRange(color.getRed() + 25 );
                     g = checkColorRange(color.getGreen() + 25);
                     b = checkColorRange(color.getBlue() + 25);
          
                     color = new Color(r, g, b);
                     tempimage.setRGB(x, y, color.getRGB());
                    
                     
                  }
            }
          return tempimage;
       }public BufferedImage filter3(BufferedImage bi) { // �ڵ����� - food
          int[][] red;
          int[][] green;
          int[][] blue;
          int width = bi.getWidth();
            int height = bi.getHeight();
         
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
           
            int br=1;
            BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
          for (int x = 0; x < bi.getWidth(); x++) {
              for (int y = 0; y < bi.getHeight(); y++) 
                  {
                     Color color = new Color(bi.getRGB(x, y));
                     int r, g, b;
                     
                 
                     red[x][y] = color.getRed();
                     green[x][y] = color.getGreen();
                     blue[x][y] = color.getBlue();
                      
                     
                     
                     if((red[x][y]+green[x][y]+blue[x][y])>300)
                        br=1;
                     else
                        br=-1;
                        
                     
                  
                     r = checkColorRange(color.getRed() + (10*br) +10);
                     g = checkColorRange(color.getGreen() + (10*br) +10);
                     b = checkColorRange(color.getBlue() + (10*br) );
          
                     color = new Color(r, g, b);
                     tempimage.setRGB(x, y, color.getRGB());
                    
                     
                  }
            }
          return tempimage;
       }public BufferedImage filter4(BufferedImage bi) { // nature ����
          int[][] red;
          int[][] green;
          int[][] blue;
          int width = bi.getWidth();
            int height = bi.getHeight();
         
            red = new int[width][height];
            green = new int[width][height];
            blue = new int[width][height];
           
            BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
          for (int x = 0; x < bi.getWidth(); x++) {
              for (int y = 0; y < bi.getHeight(); y++) 
                  {
                     Color color = new Color(bi.getRGB(x, y));
                     int r, g, b;
                     
                 
                     red[x][y] = color.getRed();
                     green[x][y] = color.getGreen();
                     blue[x][y] = color.getBlue();
                      
                     
    
                     r = checkColorRange(color.getRed() -20);
                     g = checkColorRange(color.getGreen() -40);
                     b = checkColorRange(color.getBlue() -20);
          
                     color = new Color(r, g, b);
                     tempimage.setRGB(x, y, color.getRGB());
                    
                     
                  }
            }
          return tempimage;
       }public BufferedImage filter5(BufferedImage bi) { // beauty ����
           int[][] red;
           int[][] green;
           int[][] blue;
           int width = bi.getWidth();
             int height = bi.getHeight();
          
             red = new int[width][height];
             green = new int[width][height];
             blue = new int[width][height];
             
             BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
           for (int x = 0; x < bi.getWidth(); x++) {
               for (int y = 0; y < bi.getHeight(); y++) 
                   {
                      Color color = new Color(bi.getRGB(x, y));
                      int r, g, b;
                  
                      red[x][y] = 255;
                      green[x][y] = color.getGreen();
                      blue[x][y] = color.getBlue();
                       

                      // beauty���ʹ� �̹����� ���������� ���� ���� ���� ���̱� ������ g, b�� �״�� ���ΰ� r���� ���а� ������ ����.
                      r = checkColorRange(color.getRed()+10);
                      g = color.getGreen();
                      b = checkColorRange(color.getBlue()+5);
           
                      color = new Color(r, g, b);
                      tempimage.setRGB(x, y, color.getRGB());
                     
                      
                   }
             }
           return tempimage;
        }public BufferedImage filter6(BufferedImage bi) { // analog ����
            int[][] red;
            int[][] green;
            int[][] blue;
            int width = bi.getWidth();
              int height = bi.getHeight();
           
              red = new int[width][height];
              green = new int[width][height];
              blue = new int[width][height];
              
              BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) 
                    {
                       Color color = new Color(bi.getRGB(x, y));
                       int r, g, b;
                   
                       red[x][y] = color.getRed();
                       green[x][y] = color.getGreen();
                       blue[x][y] = color.getBlue();
  												                        

                       // beauty���ʹ� �̹����� ���������� ���� ���� ���� ���̱� ������ g, b�� �״�� ���ΰ� r���� ���а� ������ ����.
                       r = (int)(color.getRed() * 0.299);
                       g = (int)(color.getGreen() * 0.587);
                       b = (int)(color.getBlue() * 0.114);
            
                       color = new Color(r+g+b, r+g+b, r+g+b);
                       tempimage.setRGB(x, y, color.getRGB());
                      
                       
                    }
              }
            return tempimage;
         }
        public BufferedImage filter7(BufferedImage bi) { // natural ����
            int[][] red;
            int[][] green;
            int[][] blue;
            int width = bi.getWidth();
              int height = bi.getHeight();
           
              red = new int[width][height];
              green = new int[width][height];
              blue = new int[width][height];
              
              BufferedImage tempimage = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) 
                    {
                       Color color = new Color(bi.getRGB(x, y));
                       int r, g, b;
                   
                       red[x][y] = color.getRed();
                       green[x][y] = color.getGreen();
                       blue[x][y] = color.getBlue();
  												                        
                       
                       // �����(= red�� green�� ����)�� �������� �������� �Ѵ�.
                       r = checkColorRange(color.getRed() + 10);
                       g = checkColorRange(color.getGreen() + 10);
                       b = checkColorRange(color.getBlue() + 3);
            
                       
                       color = new Color(r, g, b);
                       tempimage.setRGB(x, y, color.getRGB());
                      
                       
                    }
              }
            return tempimage;
         }
       
       public int checkColorRange(int newColor){
      
          if(newColor > 255)
         {
             newColor = 255;
         }
          else if (newColor < 0) {
              newColor = 0;
          }
          
          return newColor;
      }
       

       class BrightnessListener implements ChangeListener{
              public void stateChanged(ChangeEvent changeEvent) {
                 float multiple;
                 multiple =(float)(Bright_Slider.getValue())/10;
                 float[] brightKernel = {multiple};
                  BufferedImageOp bright = new ConvolveOp( new Kernel(1, 1, brightKernel));
                  bright.filter(tempImage, changeImage);
                  repaint();
                 
                 
              }
            }
      
       public void paintComponent(Graphics g) {
           g.drawImage(changeImage, 0, 0, this);
         }  

 
       public BufferedImage crop(BufferedImage bi, int a, int b, int c, int d) {
       BufferedImage tempimage = new BufferedImage(c, d, BufferedImage.TYPE_INT_RGB);      //tempimage�� ���ο� ���� (720 720 ������ RGB)�� �����.
        for(int i=0; i<c; i++)
            for(int j=0; j<d; j++)
                tempimage.setRGB(i, j, bi.getRGB(i+a, j+b));   // ���� �̹���(bi)�� ���������� 90�� ȸ��
        return tempimage;
    }
       
    
    public static BufferedImage deepCopy(BufferedImage bi) {
      ColorModel cm = bi.getColorModel();
      boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
      WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
      return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
   }
    
    @Override    //���콺 �̺�Ʈ  �������̽� ���� 
    public void mousePressed(MouseEvent e) {
       //�簢�� �ȿ����� �̺�Ʈ �۾� ���� 
             if(crp_str_point.contains(new Point(e.getX(),e.getY()))){ 
          //#1 ���콺 ��ư ����
          //�簢���� ���콺 Ŭ�� ��� ��ǥ�� ����
          //���� ���콺 ��ũ�� ��ǥ���� �簢�� ��ġ ��ǥ�� ���̸� ����
                offX = e.getX() - crp_str_point.x; offY = e.getY() - crp_str_point.y;
          //�巡�� ������ ǥ�� 
                strDragged = true;
             }
             if(crp_end_point.contains(new Point(e.getX(),e.getY()))){ 
                 //#1 ���콺 ��ư ����
                 //�簢���� ���콺 Ŭ�� ��� ��ǥ�� ����
                 //���� ���콺 ��ũ�� ��ǥ���� �簢�� ��ġ ��ǥ�� ���̸� ����
                       offX = e.getX() - crp_end_point.x; offY = e.getY() - crp_end_point.y;
                 //�巡�� ������ ǥ�� 
                       endDragged = true;
                    }
       /*��������*/}
    @Override
    public void mouseDragged(MouseEvent e) {
       if(strDragged){ 
          cropx= e.getX() - offX; cropy = e.getY() - offY; 
          if(cropx <= 0 && cropy <= 0) {
             cropx=0;
             cropy=0;
          }else if(cropx+cropw >= 720 && cropy+croph >= 720) {
             cropx=720-cropw;
             cropy=720-croph;
          }else if(cropx <= 0 && cropy+croph >= 720) {
             cropx=0; 
             cropy=720-croph;
          }else if(cropy <= 0 && cropx+cropw >= 720) {
             cropy=0; 
             cropx=720-cropw;
          }else if(cropx <= 0)
             cropx=0; 
          else if(cropy <= 0)
             cropy=0;
          else if(cropx+cropw >= 720)
             cropx=720-cropw; 
          else if(cropy+croph >= 720)
             cropy=720-croph;
          
          
          
          crp_str_point.x=cropx;
          crp_str_point.y=cropy;
          crp_end_point.x=cropx+cropw-10;
          crp_end_point.y=cropy+croph-10;
      }
       if(endDragged){ 
          crp_end_point.x = e.getX() - offX; crp_end_point.y = e.getY() - offY; 
          
          if(crp_end_point.x <= cropx && crp_end_point.y <= cropy) {
             crp_end_point.x = cropx;
             crp_end_point.y = cropy;
          }else if(crp_end_point.x >= 710 && crp_end_point.y >= 710) {
             crp_end_point.x = 710;
             crp_end_point.y = 710;
          }else if(crp_end_point.x <= cropx && crp_end_point.y >= 710) {
             crp_end_point.x = cropx;
             crp_end_point.y = 710;
          }else if(crp_end_point.y <= cropy && crp_end_point.x >= 710) {
             crp_end_point.y = cropy;
             crp_end_point.x = 710;
          }else if(crp_end_point.x <= cropx) {
             crp_end_point.x = cropx;
          }else if(crp_end_point.y <= cropy) {
             crp_end_point.y = cropy;
          }else if(crp_end_point.y >= 710) {
             crp_end_point.y = 710;
          }else if(crp_end_point.x >= 710) {
             crp_end_point.x = 710;
          }
          
          cropw = crp_end_point.x-cropx+10;
          croph = crp_end_point.y-cropy+10;


          
      } 
       
       drawPanel1.repaint();
    }
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseReleased(MouseEvent e) {
       //���콺 ��ư�� ������Ǹ� �巡�� ��� ���� 
       strDragged = false; 
       endDragged = false; 
      if(cropw < 0 || croph < 0) {
         cropw=1; croph=1;
         crp_end_point.x = cropx;
         crp_end_point.y = cropy;
      }
       /*��������*/}
    
    
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseEntered(MouseEvent e) {/*��������*/}    
    @Override  //���콺 �̺�Ʈ  �������̽� ���� 
    public void mouseExited(MouseEvent e) {/*��������*/}


   @Override
   public void mouseMoved(MouseEvent e) {
      // TODO Auto-generated method stub
      
   }
   
   class BeautySliderListener implements ChangeListener {
	      
	      @Override
	      public void stateChanged(ChangeEvent e) {
	         // TODO Auto-generated method stub
	         JSlider source = (JSlider)e.getSource();
	          if(!source.getValueIsAdjusting()) {
	             
	             for (int x = 0; x < changeImage.getWidth(); x++) {
	                  for (int y = 0; y < changeImage.getHeight(); y++)
	                      {
	                         Color color = new Color(MainFrame_Second.changeImage.getRGB(x, y));
	                         int slider_value = beauty_slider.getValue(); // �����̴��� ���簪�� �����´�.
	                         int r, g, b;
	                    
	                         // �����̹����� �ȼ����� ���ؾ� �Ѵ�. �׳� getRGB�� �ϸ� �����̹����� ����� �ȼ����� �� �����ϴ� ����.
	                         r = checkColorRange((int)(original_red_value[x][y] + slider_value * 40 / 100));
	                         g = checkColorRange((int)(original_green_value[x][y]));
	                         b = checkColorRange((int)original_blue_value[x][y]);
	          
	                         color = new Color(r, g, b);
	                         
	                         changeImage.setRGB(x, y, color.getRGB());
	                      
	                         repaint();
	                         
	                      }
	             }

	          }
	      
	      }

	      public int checkColorRange(int newColor){
	         
	          if(newColor > 255)
	          {
	              newColor = 255;
	          }
	          else if (newColor < 0) {
	              newColor = 0;
	          }
	          
	          return newColor;
	      }
	      
	 }
}

// �� �ڵ� �� ���ư�.
class RemoveMouse implements MouseListener { // ��Ƽ���Ÿ� ���� ������ Ŭ����

	
	static int x, y; // �����̴� ���콺�� ��ǥ��
	BufferedImage src = null;
	BufferedImage filtered_img = null;
	BufferedImageOp operation;
	Color[][] temp_color = new Color[20][20];
	int r, g, b;
	/*
	Color[][] mean_filter_color = new Color[20][20];
	int mean_value_sum[] = new int[400];
	int r, g, b;
	BufferedImage mean_filter_img = null;
	*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		x = e.getX(); // x��ǥ�� �޾ƿ���
		y = e.getY(); // y��ǥ�� �޾ƿ���
			
		System.out.println("x=" + x + ", y=" + y);
		
		src = MainFrame_Second.changeImage.getSubimage(RemoveMouse.x - 10, RemoveMouse.y - 10, 20, 20); // �̹��� ���� Ŭ���� �κ��̶� �� ������ �߶� ������ �� �ȼ� ���� 400��
		
		float[] remove_kernel = {0, (float) 0.2, 0, (float) 0.2, (float) 0.2, (float) 0.2, 0, (float) 0.2, 0};
		
		operation = new ConvolveOp(new Kernel(1, 1, remove_kernel));
		BufferedImage dest = operation.filter(src, null);

	 
	    for(int h=0; h<20; h++) {
	    	for(int w=0; w<20; w++) {
	    		
	    		temp_color[h][w] = new Color(dest.getRGB(h, w));
	    		MainFrame_Second.changeImage.setRGB(x + w, y + h, temp_color[h][w].getRGB());
	    		
	    	}
	    }

		
		
		
		// �Ʒ� �ڵ�� RGB���󿡼� �� ���ư���.    
		/*
		int count = 0; // �迭 �ε����� ���� ����

        // ��Ƽ���Ÿ� ���� �ڵ�
		mean_filter_img = MainFrame_Second.changeImage.getSubimage(RemoveMouse.x - 10, RemoveMouse.y - 10, 20, 20); // �̹��� ���� Ŭ���� �κ��̶� �� ������ �߶� ������ �� �ȼ� ���� 400��
        int filter_height = 20; //MainFrame_Second.mean_filter_img.getHeight(); // 20
        int filter_width = 20; //MainFrame_Second.mean_filter_img.getWidth(); // 20
        
        for(int h=0; h<filter_height; h++) {
       	 	for(int w=0; w<filter_width; w++) {
       	 		mean_filter_color[h][w] = new Color(mean_filter_img.getRGB(h, w));
       	 		
       	 		r = mean_filter_color[h][w].getRed();
       	 		g = mean_filter_color[h][w].getGreen();
       	 		b = mean_filter_color[h][w].getBlue();
 	
       	 		mean_value_sum[count] = r + g + b; // �ȼ����� mean_value_sum �迭�� ���ʴ�� ����
       	 		count++;
       	 	}
        }
        
        System.out.println(mean_value_sum);
        Arrays.sort(mean_value_sum);
        
        int mean = mean_value_sum[200]; // �߰��� �ִ� ȭ�Ұ�
        
        // �߾� ���͸� ���� (mean_filter_img�� ȭ�Ұ��� ��� mean���� �ٲ۴�)
        for(int h=0; h<filter_height; h++) {
       	 	for(int w=0; w<filter_width; w++) {
       	 		MainFrame_Second.changeImage.setRGB(h, w, mean);
       	 	}
        }
        */
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}

class MyActionListener implements MouseListener {

   static Point image_point_in_MouseListener;
   static BufferedImage cropped_img;
   static BufferedImage zoomed_img;
   static int count = 0;
   int x, y; // image_point_in_class�� x, y��
   
  
   public static BufferedImage go_cropped() {
      return cropped_img;
   }
   
   public static BufferedImage go_zoomed() {
      return zoomed_img;
   }
   
   @Override
   public void mouseClicked(MouseEvent e) { // �����̹��� ���� �ƹ����� Ŭ���ϸ�, �ش� �̹��� �������� ��ǥ�� ���ȴ�.
      // TODO Auto-generated method stub
      
      cropped_img = MyActionListener.resize(MainFrame_Second.empty_image2, 30, 30);
      zoomed_img = MyActionListener.resize(MainFrame_Second.empty_image2, 100, 100);
      
      if (MainFrame_Second.zoom_button_clicked_count % 2 == 1) { // zoom_button�� ������ ���� �����
         
         image_point_in_MouseListener = e.getPoint();
         x = (int)image_point_in_MouseListener.getX();
         y = (int)image_point_in_MouseListener.getY();
         
         
         if(x < 30) { // ���콺�� Ŭ���� ���� �ʹ� ���� ���̸� (�ʺ� ����)
            x = 30;
         }
         else if (x > MainFrame_Second.changeImage.getWidth()-30 ) { // ���콺�� Ŭ���� ���� �ʹ� ������ ���̸� (�ʺ� ����)
            x = MainFrame_Second.changeImage.getWidth()-30;
         }
         else if (y < 30) { // ���콺�� Ŭ���� ���� �ʹ� �����̸� (���� ����)
            y = 30;
         }
         else if (y > MainFrame_Second.changeImage.getHeight()-30 ) { // ���콺�� Ŭ���� ���� �ʹ� �Ʒ����̸� (���� ����)
            y = MainFrame_Second.changeImage.getHeight()-30;
         }
         
         
         // BufferedImage Ŭ������ getSubimage() : �̹��� �ڸ��� �Լ�
         cropped_img = MainFrame_Second.changeImage.getSubimage(x-15, y-15, 30, 30); // (x-15, y-15)��ġ���� ���� 30, ���� 30��ŭ �߶�´�.
                     
         // �̹����� Ȯ���ϴ� �Լ� (�ϴܿ� ����)
         zoomed_img = resize(cropped_img, 100, 100);

         count++;
         go_cropped();
         go_zoomed();
         
         MainFrame_Second.get2.setIcon(new ImageIcon(cropped_img));
         MainFrame_Second.get3.setIcon(new ImageIcon(zoomed_img));
         //System.out.println("������ ��ư Ȱ��ȭ �߿� ������ Ŭ���� Ƚ�� :" + count);
      }
   }
   
   @Override
   public void mousePressed(MouseEvent e) {}

   @Override
   public void mouseReleased(MouseEvent e) {}

   @Override
   public void mouseEntered(MouseEvent e) {}

   @Override
   public void mouseExited(MouseEvent e) {}

   // �̹��� Ȯ�� �Լ�
   static BufferedImage resize(BufferedImage img, int for_resized_Width, int for_resized_Height) {  
      
      int w = img.getWidth(); // �ʺ�
      int h = img.getHeight(); // ����
      BufferedImage zoomed_img = new BufferedImage(for_resized_Width, for_resized_Height, img.getType());  
          
      /* GraphicsŬ���� : �׷��� ��ü�� ���� �� ����
          ��, Graphics ��ü�� ����� ������ CreateGraphics�� ȣ���� ����, ����� ��ģ �Ŀ��� Dispose�� ȣ���ؾ� �Ѵ�.*/
      Graphics2D g = zoomed_img.createGraphics();
          
      /* RenderingHintsŬ���� : �پ��� �������� �����Ѵ�. (Bilinear, Bicubic ��)
         �̹��� Ȯ��� ����� �ȼ�����(�ٸ���� ����?)�� ��������. */
      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC); //BILINEAR);
          
      /* http://blog.daum.net/clamp83/56
         drawImage() : �̹����� �κп����� �׸� �� ����. �Ǵ� Ȯ��/��ҵ� ����.
         g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer) : �̹��� img�� (sx1, sy1, sx2, sy2)������ (dx1, dy1, dx2, dy2)������ �׸���. */
      g.drawImage(img, 0, 0, for_resized_Width, for_resized_Height, 0, 0, w, h, null);
      g.dispose();
          
      return zoomed_img;
   }
   
}



//�� ��° ������ �� 


//���� �Լ�
public class project {
    public static void main(String[] args) {
    
        new MainFrame_One();
       

    }
}