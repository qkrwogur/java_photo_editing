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


//첫 번째 프레임
class MainFrame_One extends JFrame implements MouseListener {    
    
    BufferedImage img;                            //처음이미지 변수
    MainFrame_One() {
        super("시작");                     //창이름
        
      try {
         File sourcemage = new File(".\\start.jpg");//자바\GUI\GUI\. 안에 존재하는 이미지 가져온다.
         img =ImageIO.read(sourcemage);            //이미지를 가져와 img에 저장
      }catch(IOException e) {
         System.out.println("이미지 파일이 없다");         //이미지가 없으면 콘솔 창에 에러 출력  
         
      }
      
      
        this.setVisible(true);// GUI 화면에 호출
      
      this.setSize(1440,900);                     // frame 사이즈  1440,900
      this.setLocation(0,0);                     // 프로그램이 윈도우에 나타나는 위치 0, 0
      this.setResizable(true);                  // 프로그램 창의 크기 조절 허용
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종류 버튼 생성
      this.setLayout(null);                     //배치를 좌표로 하기 위해 null값을 추가
      this.getContentPane().setBackground(Color.WHITE);//배경색을 하얗게 만든다.
      
      JLabel Ph = new JLabel(new ImageIcon(img));      //이미지를 라벨에 넣는다.
      Ph.setBounds(100, 80, 700, 700);            //이미지를 x자표 100 y자표 80 크기는 가로 700 세로 700 으로 출력 
      this.add(Ph);                           //이미지를 담은 라벨을 화면에 추가                  
      
      
      JLabel lbl = new JLabel("편집 시작하기 ▶▶▶");      //글자 라벨을 생성
        lbl.setFont(getFont().deriveFont(50.0f));      //글자크기를 50으로 한다.
        lbl.setBounds(900, 350, 600, 50);            //x좌표 900 y좌표 350하고 크기를 가로 600,세로 50
        this.add(lbl);                           //라벨을 화면에 추가
        lbl.addMouseListener(this);                  //라벨 클릭시 이벤트 발생
        
        
    }
   
    @Override                                   //마우스 이벤트  인터페이스 구현 
    public void mouseClicked(MouseEvent e) {        
        new MainFrame_Second();                   //여기가 프레임 전환 역할
        this.setVisible(false);
    }
    @Override    //마우스 이벤트  인터페이스 구현 
    public void mousePressed(MouseEvent e) {/*구현생략*/}
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseReleased(MouseEvent e) {/*구현생략*/}
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseEntered(MouseEvent e) {/*구현생략*/}    
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseExited(MouseEvent e) {/*구현생략*/}
}//첫 번째 프레임 끝
 
class MainFrame_Second extends JFrame implements MouseListener, MouseMotionListener {
   
   public static final int YH = 830;
   ImageIcon imgLoudImage; // 업로드 이미지
   ImageIcon imgSave;       // 세이브 이미지
   
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
   
   String filePath;      // 파일 경로 변수
   String filefilter;      // 파일 확장자 변수
   static BufferedImage newImage;      // 새로운 이미지   
 
   static BufferedImage changeImage;
   BufferedImage tempImage;
   
 
   
   BufferedImage cropImage;      // 자른 이미지를 임시 저장할 이미지 버퍼
     
   int w = 720;         // 이미지의 기본 너비
   int h = 720;         // 이미지의 기본 높이

   int cropx=160, cropy=160, cropw=400, croph=400; //이미지 자르기 시작점과 너비 좌표 
   boolean cropon = false; // 이미지 자르기가 시작되었는지 저장하는 변수 
   Rectangle crp_str_point= new Rectangle(cropx,cropy,10,10);
   Rectangle crp_end_point= new Rectangle(cropx+cropw-10,cropy+croph-10,10,10);

   boolean strDragged=false;
   boolean endDragged=false;
   int offX=0;
   int offY=0;
   
   
   public static final boolean RIGHT = true;   // 오른쪽 회전을 알리기 위한 위한 상수
   public static final boolean LEFT = false;   // 왼쪽 회전을 알리기 위한 상수
   
   DrawPanel drawPanel1 = new DrawPanel();   // 이미지를 그릴 panel
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
    
    JButton zoom_button = new JButton("돋보기");

   static BufferedImage empty_image2 = null;
   BufferedImage cropped_img = null;
   BufferedImage zoomed_img = null;
   Container c = getContentPane();
   JPanel panel1 = new JPanel();
   JLabel get1 = new JLabel();
   Point image_point_in_class; // // 마우스 클릭된 곳의 좌표를 받아올 변수
   static JLabel get2 = new JLabel(); // 자르기가 된 이미지를 display하기 위한 label
   static JLabel get3 = new JLabel(); // 잘라진 이미지를 확대한 것을 display하기 위한 label
   Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
   
   int image_clicked_count = 0;
   static int zoom_button_clicked_count = 0;

   static int[][] original_red_value;
   static int[][] original_green_value;
   static int[][] original_blue_value;
   
   JSlider beauty_slider = new JSlider(0, 100, 100);
   
     MainFrame_Second(){
           
      imgLoudImage = new ImageIcon(".\\UpLoud.Png");  //이미지 경로
      imgSave = new ImageIcon(".\\save.Png");  //이미지 경로
      
      auto = new ImageIcon(".\\auto.Png");  //이미지 경로
      auto2 = new ImageIcon(".\\auto2.Png");
      
      ratation = new ImageIcon(".\\ratation.Png");  //이미지 경로
      ratation2 = new ImageIcon(".\\ratation2.Png");  //이미지 경로
      
      bright = new ImageIcon(".\\bright.Png");  //이미지 경로
      bright2 = new ImageIcon(".\\bright2.Png");  //이미지 경로
   
      filter = new ImageIcon(".\\filter.Png");  //이미지 경로
      filter2 = new ImageIcon(".\\filter2.Png");  //이미지 경로

      
      cut = new ImageIcon(".\\cut.png");  //이미지 경로
      cut2 = new ImageIcon(".\\cut2.png");  //이미지 경로
      cut3 = new ImageIcon(".\\cut3.png");  //이미지 경로
      cut4 = new ImageIcon(".\\cut4.png");  //이미지 경로
      cancel = new ImageIcon(".\\cancel.png");  //이미지 경로
      cancel2 = new ImageIcon(".\\cancel2.png");  //이미지 경로
 
      
      resize = new ImageIcon(".\\resize.Png");  //이미지 경로
      resize2 = new ImageIcon(".\\resize2.Png");  //이미지 경로
      
      person = new ImageIcon(".\\person.Png");  //이미지 경로
      person2 = new ImageIcon(".\\person2.Png");  //이미지 경로
      
      food = new ImageIcon(".\\food.Png");  //이미지 경로
      food2 = new ImageIcon(".\\food2.Png");  //이미지 경로
      
      view = new ImageIcon(".\\view.Png");  //이미지 경로
      view2 = new ImageIcon(".\\view2.Png");  //이미지 경로
      
      left_rotation = new ImageIcon(".\\left_rotation.Png");  //이미지 경로
      right_rotation = new ImageIcon(".\\right_rotation.Png");  //이미지 경로
      
      filter_beauty = new ImageIcon(".\\filter_beauty.Png");  //이미지 경로
      filter_Natural = new ImageIcon(".\\Natural.Png");  //이미지 경로   
      filter_Nature = new ImageIcon(".\\Nature.Png");  //이미지 경로
      filter_Pastel = new ImageIcon(".\\Pastel.Png");  //이미지 경로
      filter_Analog = new ImageIcon(".\\Analog.Png"); 
      Home = new ImageIcon(".\\Home.Png");  //이미지 경로
      

      try {
         File empty_image = new File(".\\empty.jpg");
         empty_image2 = ImageIO.read(empty_image);
         
      }catch(IOException e) {
         System.out.println("이미지 파일을 찾을 수 없음");
      }


      
      this.setVisible(true);// GUI 화면에 호출
      this.setSize(1440,960);                     // frame 사이즈  1440,900
      this.setLocation(0,0);                     // 프로그램이 윈도우에 나타나는 위치 0, 0
      this.setResizable(true);                  // 프로그램 창의 크기 조절 허용
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종류 버튼 생성
      this.setLayout(null);                     //배치를 좌표로 하기 위해 null값을 추가
      this.getContentPane().setBackground(Color.WHITE);//배경색을 하얗게 만든다.
      
      mainPanel.setSize(1440,960);                     // frame 사이즈  1440,900
      mainPanel.setLocation(0,0);                     // 프로그램이 윈도우에 나타나는 위치 0, 0
      mainPanel.setLayout(null);                     //배치를 좌표로 하기 위해 null값을 추가
      mainPanel.setBackground(Color.WHITE);//배경색을 하얗게 만든다.
      this.add(mainPanel);
      
        JLabel LoudInmge = new JLabel("Load Image",imgLoudImage,JLabel.CENTER);
        LoudInmge.setBounds(20, YH, 80, 80);            //x좌표 900 y좌표 350하고 크기를 가로 600,세로 50
        mainPanel.add(LoudInmge);   //라벨을 화면에 추가
        LoudInmge.addMouseListener(this);   
        
        JLabel Save = new JLabel("Save Image",imgSave,JLabel.CENTER);
        Save.setBounds(1300, YH, 80, 80);            //x좌표 900 y좌표 350하고 크기를 가로 600,세로 50
        mainPanel.add(Save);                           //라벨을 화면에 추가
        Save.addMouseListener(this);   
      
 
        autoL = new JLabel("auto Image",auto,JLabel.CENTER);//오토
        autoL.setBounds(70, 25, 60, 60);            //
        mainPanel.add(autoL);                           //라벨을 화면에 추가
        autoL.addMouseListener(this);   
        //선택  된 페널
        autoL2 = new JLabel("auto2 Image",auto2,JLabel.CENTER);//오토
        autoL2.setBounds(70, 25, 60, 60);            //
        mainPanel.add(autoL2);                           //라벨을 화면에 추가
        autoL2.setVisible(false);
        
        ratationL = new JLabel("ratation Image",ratation,JLabel.CENTER);
        ratationL.setBounds(300, 25, 60, 60);            //
        mainPanel.add(ratationL);                           //라벨을 화면에 추가
        ratationL.addMouseListener(this);   
        //선택  된 페널
        ratationL2 = new JLabel("ratation2 Image",ratation2,JLabel.CENTER);
        ratationL2.setBounds(300, 25, 60, 60);            //
        mainPanel.add(ratationL2);                        //라벨을 화면에 추가
        ratationL2.setVisible(false);
        
        brightL = new JLabel("bright Image",bright,JLabel.CENTER);
        brightL.setBounds(530, 25, 60, 60);            //
        mainPanel.add(brightL);                           //라벨을 화면에 추가
        brightL.addMouseListener(this);   
        //선택  된 페널
        brightL2 = new JLabel("bright2 Image",bright2,JLabel.CENTER);
        brightL2.setBounds(530, 25, 60, 60);            //
        mainPanel.add(brightL2);                           //라벨을 화면에 추가
        brightL2.setVisible(false);   
        
        filterL = new JLabel("filter Image",filter,JLabel.CENTER);
        filterL.setBounds(760, 25, 60, 60);            //
        mainPanel.add(filterL);                           //라벨을 화면에 추가
        filterL.addMouseListener(this);   
        //선택  된 페널
        
        filterL2 = new JLabel("filter2 Image",filter2,JLabel.CENTER);
        filterL2.setBounds(760, 25, 60, 60);            //
        mainPanel.add(filterL2);                           //라벨을 화면에 추가
        filterL2.setVisible(false);   
       
        cutL = new JLabel("cut Image",cut,JLabel.CENTER);
        cutL.setBounds(990, 25, 60, 60);            //
        mainPanel.add(cutL);                           //라벨을 화면에 추가  
        cutL.addMouseListener(this);
        
        //선택  된 페널
        cutL2 = new JLabel("cut2 Image",cut2,JLabel.CENTER);
        cutL2.setBounds(990, 25, 60, 60);            //
        mainPanel.add(cutL2);                           //라벨을 화면에 추가
        cutL2.setVisible(false); 
        cutL2.addMouseListener(this);
        
        cutL3 = new JLabel("cut3 Image",cut3,JLabel.CENTER);
        cutL3.setBounds(500, YH, 80, 80);            //
        mainPanel.add(cutL3);                           //라벨을 화면에 추가
        cutL3.setVisible(false); 
        cutL3.addMouseListener(this);
        
        cutL4 = new JLabel("cut4 Image",cut4,JLabel.CENTER);
        cutL4.setBounds(500, YH, 80, 80);            //
        mainPanel.add(cutL4);                           //라벨을 화면에 추가
        cutL4.setVisible(false); 
        
        
        cancelL = new JLabel("cancel Image",cancel,JLabel.CENTER);
        cancelL.setBounds(800, YH, 80, 80);            //
        mainPanel.add(cancelL);                           //라벨을 화면에 추가
        cancelL.setVisible(false); 
        cancelL.addMouseListener(this);
        
        

        
        resizeL = new JLabel("resize Image",resize,JLabel.CENTER);
        resizeL.setBounds(1210, 25, 60, 60);            //
        mainPanel.add(resizeL);                           //라벨을 화면에 추가
        resizeL.addMouseListener(this);   
        //선택  된 페널
        resizeL2 = new JLabel("resize2 Image",resize2,JLabel.CENTER);
        resizeL2.setBounds(1210, 25, 60, 60);            //
        mainPanel.add(resizeL2);                           //라벨을 화면에 추가
        resizeL2.setVisible(false);
        
        // 잡티제거: 클릭된 마우스 좌표값을 얻어옴.
        //RemoveMouse listener2 = new RemoveMouse();
        //drawPanel1.addMouseListener(listener2); // (코드 안 돌아감.)
        
        zoom_button.setSize(150,80);   // 불러오기 버튼 사이즈  120, 50
        zoom_button.setLocation(500, YH);   // 버튼 위치 1300, 80
        
       
        ActionListener eventHandler = new ActionListener() { // zoom_button을 위한 이벤트 핸들러

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            if(e.getSource() == zoom_button) { // zoom_button이 눌리면
               
               MainFrame_Second.zoom_button_clicked_count++;
               
               if (MainFrame_Second.zoom_button_clicked_count % 2 == 1) {
                  zoom_button.setText("돋보기 중지하기");
                  setCursor(CROSSHAIR_CURSOR); // 커서 모양 변경
                  
                           
               }         
               else if (MainFrame_Second.zoom_button_clicked_count % 2 == 0) {
                  zoom_button.setText("돋보기");
                  setCursor(DEFAULT_CURSOR); // 커서 모양을 원래대로 변경
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
        mainPanel.add(personL);                           //라벨을 화면에 추가
        personL.addMouseListener(this);
        personL.setVisible(false);
        //선택  된 페널
        personL2 = new JLabel("person2 Image",person2,JLabel.CENTER);
        personL2.setBounds(300, YH, 90, 90);            //
        mainPanel.add(personL2);                           //라벨을 화면에 추가
        personL2.setVisible(false);
        
        foodL = new JLabel("food Image",food,JLabel.CENTER);
        foodL.setBounds(650, YH, 90, 90);            //
        mainPanel.add(foodL);                           //라벨을 화면에 추가
        foodL.addMouseListener(this);
        foodL.setVisible(false);
        //선택  된 페널
        foodL2 = new JLabel("food2 Image",food2,JLabel.CENTER);
        foodL2.setBounds(650, YH, 90, 90);            //
        mainPanel.add(foodL2);                           //라벨을 화면에 추가
        foodL2.setVisible(false);
        
        viewL = new JLabel("view Image",view,JLabel.CENTER);
        viewL.setBounds(1000, YH, 90, 90);            //
        mainPanel.add(viewL);                           //라벨을 화면에 추가
        viewL.addMouseListener(this);
        viewL.setVisible(false);
        //선택  된 페널
        viewL2 = new JLabel("view2 Image",view2,JLabel.CENTER);
        viewL2.setBounds(1000, YH, 90, 90);            //
        mainPanel.add(viewL2);                           //라벨을 화면에 추가
        viewL2.setVisible(false);
        
        left_rotationL = new JLabel("left_rotation Image",left_rotation,JLabel.CENTER);
        left_rotationL.setBounds(500, YH, 90, 90);            //
        mainPanel.add(left_rotationL);                           //라벨을 화면에 추가
        left_rotationL.addMouseListener(this);
        left_rotationL.setVisible(false);
        
        right_rotationL = new JLabel("right_rotation Image",right_rotation,JLabel.CENTER);
        right_rotationL.setBounds(800, YH, 90, 90);            //
        mainPanel.add(right_rotationL);                           //라벨을 화면에 추가
        right_rotationL.addMouseListener(this);
        right_rotationL.setVisible(false);
        
        filter_beautyL = new JLabel("filter_beauty Image",filter_beauty,JLabel.CENTER);
        filter_beautyL.setBounds(300, YH, 80, 80);            //
        mainPanel.add(filter_beautyL);     
        filter_beautyL.addMouseListener(this);//라벨을 화면에 추가
        filter_beautyL.setVisible(false);
        
        filter_NaturalL = new JLabel("filter_Natural Image",filter_Natural,JLabel.CENTER);
        filter_NaturalL.setBounds(500, YH, 80, 80);            //
        mainPanel.add(filter_NaturalL);                           //라벨을 화면에 추가
        filter_NaturalL.setVisible(false);
        filter_NaturalL.addMouseListener(this);
        
        filter_NatureL = new JLabel("filter_Nature Image",filter_Nature,JLabel.CENTER);
        filter_NatureL.setBounds(700, YH, 80, 80);            //
        mainPanel.add(filter_NatureL);                           //라벨을 화면에 추가
        filter_NatureL.setVisible(false);
        filter_NatureL.addMouseListener(this);
        
        filter_PastelL = new JLabel("filter_Pastel Image",filter_Pastel,JLabel.CENTER);
        filter_PastelL.setBounds(900, YH, 80, 80);            //
        mainPanel.add(filter_PastelL);                           //라벨을 화면에 추가
        filter_PastelL.setVisible(false);
        filter_PastelL.addMouseListener(this);
        
        filter_AnalogL = new JLabel("filter_Analog Image",filter_Analog,JLabel.CENTER);
        filter_AnalogL.setBounds(1100, YH, 80, 80);            //
        mainPanel.add(filter_AnalogL);                           //라벨을 화면에 추가
        filter_AnalogL.setVisible(false);
        filter_AnalogL.addMouseListener(this);
        
        HomeL = new JLabel("Home Image",Home,JLabel.CENTER);
        HomeL.setBounds(10, 720, 100, 80);            //
        mainPanel.add(HomeL);                           //라벨을 화면에 추가
       
        HomeL.addMouseListener(this);
        
        

        //하단 버튼 및 슬라이더  
       // Bright_Slider.setPaintTicks(true);//슬라이더 눈금 출력
       // Bright_Slider.setPaintTrack(true);     
        Bright_Slider.setLocation(200, YH);//슬라이더 위치
        Bright_Slider.setSize(1000,100);    //스라이더 세로 길이1000 가로 길이 100
        Bright_Slider.addChangeListener(new BrightnessListener());
        mainPanel.add(Bright_Slider);
        Bright_Slider.setVisible(false);

        beauty_slider.setPaintLabels(true);//슬라이더의 하단의 숫자 출력
        beauty_slider.setPaintTicks(true);//슬라이더 눈금 출력
        beauty_slider.setPaintTrack(true);
        beauty_slider.setMajorTickSpacing(5);//20씩 숫자 표현
        beauty_slider.setMinorTickSpacing(5);//눈금은 5씩 증가
        beauty_slider.setLocation(290, YH);//슬라이더 위치
        beauty_slider.setSize(900,100);    
        beauty_slider.addChangeListener(new BeautySliderListener());
        beauty_slider.setVisible(false);
        mainPanel.add(beauty_slider);
        
      drawPanel1.setLocation(350,100);   // 드로우 페널 1 위치  20 80
      drawPanel1.setSize(720,720);      // 드로우 페널 1 사이즈 720 720
      drawPanel1.addMouseListener(this);
      drawPanel1.addMouseMotionListener(this);
      mainPanel.add(drawPanel1);

      Up.setLocation(0,0);   // 드로우 페널 1 위치  20 80
      Up.setSize(1440,100);      // 드로우 페널 1 사이즈 720 720
      Up.setBackground(new Color(220,220,220));   // 드로우 페널 배경색 35, 35, 35
      mainPanel.add(Up);
      
      Down.setLocation(0,820);   // 드로우 페널 1 위치  20 80
      Down.setSize(1440,100);      // 드로우 페널 1 사이즈 720 720
      Down.setBackground(new Color(220,220,220));   // 드로우 페널 배경색 35, 35, 35
      mainPanel.add(Down);
      

      
      
   }

     class DrawPanel extends JPanel{      // DRAWPANEL 제어 CLASS 

             public void paintComponent(Graphics g) {
                super.paintComponent(g);         // 기존 컨포넌트 모양의 변화를 주고 싶을 때  작성 후 밑에 코드 작성
                Graphics2D g2 = (Graphics2D)g;
                g2.drawImage(changeImage, 0, 0, null);      // 변경된 이미지를 그려라.\
                if(cropon==true)
                {
                   g2.setColor(Color.red);         // g2를 red
                 g2.drawRect(cropx, cropy, cropw, croph); 
                 g2.fillRect(crp_str_point.x, crp_str_point.y, crp_str_point.width, crp_str_point.height); 
                 g2.fillRect(crp_end_point.x, crp_end_point.y, crp_end_point.width, crp_end_point.height); 
                }

             }
       }

                                      
        //마우스 이벤트  인터페이스 구현 
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
         
             
         
         JFileChooser chooser = new JFileChooser();      // 파일 관리자를 만든다.


         JLabel myButton = (JLabel)e.getSource();      // 버튼에서 발생한 이벤트를 mybutton에 담는다.
         String temp = myButton.getText();      // 이벤트가 발생한 버튼의 이름을 문자열 형태로 temp에 담는다.
         if(temp.equals("Load Image")) {         // 만약 눌린 버튼이 사진불러오기라면
            
            FileNameExtensionFilter JPEGfilter = new FileNameExtensionFilter("JPEG(*.jpeg, *.jpg)", "jpg", "jpeg");   // jpg, jpeg확장자만을 찾는 JPG&GIF Images확장자 필터를 만든다.
            FileNameExtensionFilter PNGfilter = new FileNameExtensionFilter("PNG(*.png)", "png");   // png 확장자만을 찾는 PNG Images확장자 필터를 만든다.
            FileNameExtensionFilter BMPfilter = new FileNameExtensionFilter("BMP(*.bmp)", "bmp");   // bmp 확장자만을 찾는 BMP Images확장자 필터를 만든다.
            chooser.setFileFilter(JPEGfilter);   //파일 관리자에 필터를 넣는다.
            chooser.setFileFilter(PNGfilter);   //파일 관리자에 필터를 넣는다.
            chooser.setFileFilter(BMPfilter);   //파일 관리자에 필터를 넣는다.

            int ret = chooser.showOpenDialog(null);   // 파일 관리자(열기)에서 확인을 눌렀는지 여부를 ret에 담는다.
            if(ret!= JFileChooser.APPROVE_OPTION) {   // 경로를 선택하지 않았을 경우
               JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);   // 경로를 선택하지 않을 경우 경고 그림이 나타나는 메세지를 출력한다. 
               return;

            }   
            filePath=chooser.getSelectedFile().getPath();   // filePath에 선택된 파일의 경로 데이터를 담는다.


            try {

               Image resizeImage;               // 
               BufferedImage image;            // 이미지버퍼 image를 만든다.
               File input = new File(filePath);   // input에 파일경로에서 가져온 파일을 담는다.
               image = ImageIO.read(input);      // image 이미지 버퍼에 파일 경로에서 읽어온 이미지 파일을 담는다.
               resizeImage = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);   // 이미지를 520 760 사이즈에 맞게 품질을 유지시키면서 크기 변환을 시켜 resizeImage에 담는다.
               newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);      // newImage에 새로운 버퍼 (720 720 사이즈 RGB)를 만든다.
               Graphics g = newImage.getGraphics(); // 새로운 이미지버퍼의 그리기 도구 g에 담는다. 
               g.drawImage(resizeImage, 0, 0, null); // 그리기 도구 g로 resizeImage를 0,0 부터 그린다.
               g.dispose(); // 리소스 해제
               
               //Bright_Slider_int++;


            } catch (IOException e1) {             // 입출력 에러 발생 시
               // TODO Auto-generated catch block
               e1.printStackTrace();            // 에러의 내부정보를 출력 
            }
            changeImage= new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            changeImage=deepCopy(newImage);
            
            tempImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            tempImage=deepCopy(newImage);
            
            
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제
            }
         else if(temp.equals("Save Image")) {
            FileNameExtensionFilter JPEGfilter = new FileNameExtensionFilter("JPEG(*.jpeg, *.jpg)", "jpg", "jpeg");   // jpg, jpeg확장자만을 찾는 JPG&GIF Images확장자 필터를 만든다.
            FileNameExtensionFilter PNGfilter = new FileNameExtensionFilter("PNG(*.png)", "png");   // png 확장자만을 찾는 PNG Images확장자 필터를 만든다.
            FileNameExtensionFilter BMPfilter = new FileNameExtensionFilter("BMP(*.bmp)", "bmp");   // bmp 확장자만을 찾는 BMP Images확장자 필터를 만든다.
            chooser.setFileFilter(JPEGfilter);   //파일 관리자에 필터를 넣는다.
            chooser.setFileFilter(PNGfilter);   //파일 관리자에 필터를 넣는다.
            chooser.setFileFilter(BMPfilter);
            int ret = chooser.showSaveDialog(null);      // 파일 저장 관리자 창을 출력
            if(ret!= JFileChooser.APPROVE_OPTION) {   // 경로를 선택하지 않았을 경우
               JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);   // 경로를 선택하지 않을 경우 경고 그림이 나타나는 메세지를 출력한다. 
               return;

            }
            filePath=chooser.getSelectedFile().getPath();   // filePath에 선택된 파일의 경로 데이터를 담는다.
            filefilter=chooser.getFileFilter().getDescription();   // filefilter에서 선택한 확장자를 저장


            try {
               if(filefilter.equals("JPEG(*.jpeg, *.jpg)")) {      // JPEG를 선택한 경우
                  filefilter=".jpeg";                        // 확장자를 JPEG로 설정
                  File output = new File(filePath+filefilter);   // 파일 경로를 담은 파일 output 선언
                  ImageIO.write(changeImage, "jpeg", output);      // newImage를 jpeg형식으로 저장
               }
               else if(filefilter.equals("PNG(*.png)")) {         // PNG를 선택한 경우
                  filefilter=".png";                        // 확장자를 JPEG로 설정
                  File output = new File(filePath+filefilter);   // 파일 경로를 담은 파일 output 선언
                  ImageIO.write(changeImage, "png", output);         // newImage를 png형식으로 저장
               }

               
            } catch (IOException e1) {             // 입출력 에러 발생 시
               // TODO Auto-generated catch block
               e1.printStackTrace();            // 에러의 내부정보를 출력 
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
            
            
            changeImage = rotation(changeImage, RIGHT);            // 이미지 회전 메소드 호출
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제
            drawPanel1.repaint();
         }else if(temp.equals("right_rotation Image")) {
            
            ratationL2.setVisible(true);
            left_rotationL.setVisible(true);
            right_rotationL.setVisible(true);
            
            changeImage = rotation(changeImage, LEFT);            // 이미지 회전 메소드 호출
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제
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
                       
                      
                      // beauty필터는 이미지에 전반적으로 붉은 색을 더할 것이기 때문에 g, b는 그대로 냅두고 r값만 폭넓게 변경할 것임.
                      r = checkColorRange(color.getRed() + 40); // 최대 40까지만 더하도록 하자. 그 이상 더하면 이상함.
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
             cropx=160; cropy=160; cropw=400; croph=400; //이미지 자르기 시작점과 너비 좌표 
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
             Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
             g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
             g4.dispose(); // 리소스 해제
             drawPanel1.repaint();

                   
         }else if(temp.equals("cancel Image")) {
             
            drawPanel1.repaint();

             
           
         }else if(temp.equals("resize Image")) {

             resizeL2.setVisible(true);
             zoom_button.setVisible(true);
             get2.setVisible(true);
             get3.setVisible(true);
             // 돋보기
            
            
         }else if(temp.equals("person Image")) {
            
            autoL2.setVisible(true);
             personL2.setVisible(true);
             foodL.setVisible(true);
             viewL.setVisible(true);
            
            changeImage = fiter(changeImage,10,10,-1);            // 필터에 1,1,-8을  넣는다.
            changeImage = fiter(changeImage,10,10,-1);            // 필터에 1,1,-8을  넣는다.
            changeImage = filter2(changeImage);            // 필터에 1,1,-8을  넣는다.
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제s
               
            
         }else if(temp.equals("food Image")) {
            
            autoL2.setVisible(true);
            personL.setVisible(true);
            foodL2.setVisible(true);
            viewL.setVisible(true);
            
            changeImage = filter3(changeImage);
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제
            
                    
              
         }else if(temp.equals("view Image")) {
            
            autoL2.setVisible(true);
            personL.setVisible(true);
            foodL.setVisible(true);
            viewL2.setVisible(true);
            
            changeImage = filter1(changeImage);
            Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
            g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
            g4.dispose(); // 리소스 해제
            
 
            
         }else if(temp.equals("filter_Pastel Image")) {
             
            filterL2.setVisible(true);
             filter_beautyL.setVisible(true);
             filter_NaturalL.setVisible(true);
             filter_NatureL.setVisible(true);
             filter_PastelL.setVisible(true);
             filter_AnalogL.setVisible(true);
          
             changeImage = fiter(changeImage,1,1,-7);            // 필터에 1,1,-8을  넣는다.
             Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
             g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
             g4.dispose(); // 리소스 해제
            
             
          }else if(temp.equals("filter_Natural Image")) {
              
              filterL2.setVisible(true);
              filter_beautyL.setVisible(true);
              filter_NaturalL.setVisible(true);
              filter_NatureL.setVisible(true);
              filter_AnalogL.setVisible(true);
              filter_PastelL.setVisible(true);
              
              
              changeImage = filter7(changeImage);
              Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
              g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
              g4.dispose(); // 리소스 해제
              
           }else if(temp.equals("filter_Nature Image")) {
               
               filterL2.setVisible(true);
               filter_beautyL.setVisible(true);
               filter_NaturalL.setVisible(true);
               filter_NatureL.setVisible(true);
               filter_AnalogL.setVisible(true);
               filter_PastelL.setVisible(true);
               
               
               changeImage = filter4(changeImage);
               Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
               g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
               g4.dispose(); // 리소스 해제
               
            }else if(temp.equals("filter_Analog Image")) {
                
                filterL2.setVisible(true);
                filter_beautyL.setVisible(true);
                filter_NaturalL.setVisible(true);
                filter_NatureL.setVisible(true);
                filter_AnalogL.setVisible(true);
                filter_PastelL.setVisible(true);
                
                
                changeImage = filter6(changeImage);
                Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
                g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
                g4.dispose(); // 리소스 해제
                
             }else if(temp.equals("Home Image")) {
              
              changeImage=deepCopy(newImage);
               Graphics2D g4 = (Graphics2D)drawPanel1.getGraphics();   // g4에 드로우팬넬1의 그리기 권한을 준다.
               g4.drawImage(changeImage, 0, 0, null);               // defaultImage를 전부 그린다. 
               g4.dispose(); // 리소스 해제
               
            }
         
         
         
         if(Bright_Slider_int > 0) {
        	  tempImage=deepCopy(changeImage);//밝기 조절 비교 image 업데이트
         }
        
       
         
            
       }

    
       public BufferedImage fiter (BufferedImage buffImage,int corner, int edge,int identity){//필터 함수
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
       
          
       public BufferedImage rotation(BufferedImage bi, boolean rotate){   // 이미지 회전 메소드
          
         BufferedImage tempimage = new BufferedImage(bi.getHeight(), bi.getWidth(), BufferedImage.TYPE_INT_RGB);      //tempimage에 새로운 버퍼 (720 720 사이즈 RGB)를 만든다.
         if(rotate==LEFT)   // 왼쪽 90 회전
         {
            for(int i=0; i<bi.getWidth(); i++)
                  for(int j=0; j<bi.getHeight(); j++)
                      tempimage.setRGB(bi.getHeight()-1-j, i, bi.getRGB(i, j));   // 본래 이미지(bi)를 오른쪽으로 90도 회전
         }
         else if(rotate==RIGHT)   // 오른쪽 90 회전
         {
            for(int i=0; i<bi.getWidth(); i++)
                  for(int j=0; j<bi.getHeight(); j++)
                      tempimage.setRGB(j, bi.getWidth()-1-i, bi.getRGB(i, j));   // 본래 이미지(bi)를 오른쪽으로 90도 회전
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
       }public BufferedImage filter3(BufferedImage bi) { // 자동보정 - food
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
       }public BufferedImage filter4(BufferedImage bi) { // nature 필터
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
       }public BufferedImage filter5(BufferedImage bi) { // beauty 필터
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
                       

                      // beauty필터는 이미지에 전반적으로 붉은 색을 더할 것이기 때문에 g, b는 그대로 냅두고 r값만 폭넓게 변경할 것임.
                      r = checkColorRange(color.getRed()+10);
                      g = color.getGreen();
                      b = checkColorRange(color.getBlue()+5);
           
                      color = new Color(r, g, b);
                      tempimage.setRGB(x, y, color.getRGB());
                     
                      
                   }
             }
           return tempimage;
        }public BufferedImage filter6(BufferedImage bi) { // analog 필터
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
  												                        

                       // beauty필터는 이미지에 전반적으로 붉은 색을 더할 것이기 때문에 g, b는 그대로 냅두고 r값만 폭넓게 변경할 것임.
                       r = (int)(color.getRed() * 0.299);
                       g = (int)(color.getGreen() * 0.587);
                       b = (int)(color.getBlue() * 0.114);
            
                       color = new Color(r+g+b, r+g+b, r+g+b);
                       tempimage.setRGB(x, y, color.getRGB());
                      
                       
                    }
              }
            return tempimage;
         }
        public BufferedImage filter7(BufferedImage bi) { // natural 필터
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
  												                        
                       
                       // 노란색(= red와 green의 조합)이 메인으로 더해지게 한다.
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
       BufferedImage tempimage = new BufferedImage(c, d, BufferedImage.TYPE_INT_RGB);      //tempimage에 새로운 버퍼 (720 720 사이즈 RGB)를 만든다.
        for(int i=0; i<c; i++)
            for(int j=0; j<d; j++)
                tempimage.setRGB(i, j, bi.getRGB(i+a, j+b));   // 본래 이미지(bi)를 오른쪽으로 90도 회전
        return tempimage;
    }
       
    
    public static BufferedImage deepCopy(BufferedImage bi) {
      ColorModel cm = bi.getColorModel();
      boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
      WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
      return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
   }
    
    @Override    //마우스 이벤트  인터페이스 구현 
    public void mousePressed(MouseEvent e) {
       //사각형 안에서만 이벤트 작업 설정 
             if(crp_str_point.contains(new Point(e.getX(),e.getY()))){ 
          //#1 마우스 버튼 누름
          //사각형내 마우스 클릭 상대 좌표를 구함
          //현재 마우스 스크린 좌표에서 사각형 위치 좌표의 차이를 구함
                offX = e.getX() - crp_str_point.x; offY = e.getY() - crp_str_point.y;
          //드래그 시작을 표시 
                strDragged = true;
             }
             if(crp_end_point.contains(new Point(e.getX(),e.getY()))){ 
                 //#1 마우스 버튼 누름
                 //사각형내 마우스 클릭 상대 좌표를 구함
                 //현재 마우스 스크린 좌표에서 사각형 위치 좌표의 차이를 구함
                       offX = e.getX() - crp_end_point.x; offY = e.getY() - crp_end_point.y;
                 //드래그 시작을 표시 
                       endDragged = true;
                    }
       /*구현생략*/}
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
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseReleased(MouseEvent e) {
       //마우스 버튼이 릴리즈되면 드래그 모드 종료 
       strDragged = false; 
       endDragged = false; 
      if(cropw < 0 || croph < 0) {
         cropw=1; croph=1;
         crp_end_point.x = cropx;
         crp_end_point.y = cropy;
      }
       /*구현생략*/}
    
    
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseEntered(MouseEvent e) {/*구현생략*/}    
    @Override  //마우스 이벤트  인터페이스 구현 
    public void mouseExited(MouseEvent e) {/*구현생략*/}


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
	                         int slider_value = beauty_slider.getValue(); // 슬라이더의 현재값을 가져온다.
	                         int r, g, b;
	                    
	                         // 원본이미지의 픽셀값에 더해야 한다. 그냥 getRGB로 하면 원본이미지의 변경된 픽셀값을 또 변경하는 것임.
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

// ↓ 코드 안 돌아감.
class RemoveMouse implements MouseListener { // 잡티제거를 위한 리스너 클래스

	
	static int x, y; // 움직이는 마우스의 좌표값
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

		x = e.getX(); // x좌표값 받아오기
		y = e.getY(); // y좌표값 받아오기
			
		System.out.println("x=" + x + ", y=" + y);
		
		src = MainFrame_Second.changeImage.getSubimage(RemoveMouse.x - 10, RemoveMouse.y - 10, 20, 20); // 이미지 내에 클릭된 부분이랑 그 주위만 잘라서 가져옴 → 픽셀 개수 400개
		
		float[] remove_kernel = {0, (float) 0.2, 0, (float) 0.2, (float) 0.2, (float) 0.2, 0, (float) 0.2, 0};
		
		operation = new ConvolveOp(new Kernel(1, 1, remove_kernel));
		BufferedImage dest = operation.filter(src, null);

	 
	    for(int h=0; h<20; h++) {
	    	for(int w=0; w<20; w++) {
	    		
	    		temp_color[h][w] = new Color(dest.getRGB(h, w));
	    		MainFrame_Second.changeImage.setRGB(x + w, y + h, temp_color[h][w].getRGB());
	    		
	    	}
	    }

		
		
		
		// 아래 코드는 RGB영상에서 안 돌아간다.    
		/*
		int count = 0; // 배열 인덱스를 위한 변수

        // 잡티제거를 위한 코드
		mean_filter_img = MainFrame_Second.changeImage.getSubimage(RemoveMouse.x - 10, RemoveMouse.y - 10, 20, 20); // 이미지 내에 클릭된 부분이랑 그 주위만 잘라서 가져옴 → 픽셀 개수 400개
        int filter_height = 20; //MainFrame_Second.mean_filter_img.getHeight(); // 20
        int filter_width = 20; //MainFrame_Second.mean_filter_img.getWidth(); // 20
        
        for(int h=0; h<filter_height; h++) {
       	 	for(int w=0; w<filter_width; w++) {
       	 		mean_filter_color[h][w] = new Color(mean_filter_img.getRGB(h, w));
       	 		
       	 		r = mean_filter_color[h][w].getRed();
       	 		g = mean_filter_color[h][w].getGreen();
       	 		b = mean_filter_color[h][w].getBlue();
 	
       	 		mean_value_sum[count] = r + g + b; // 픽셀값을 mean_value_sum 배열에 차례대로 저장
       	 		count++;
       	 	}
        }
        
        System.out.println(mean_value_sum);
        Arrays.sort(mean_value_sum);
        
        int mean = mean_value_sum[200]; // 중간에 있는 화소값
        
        // 중앙 필터링 적용 (mean_filter_img의 화소값을 모두 mean으로 바꾼다)
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
   int x, y; // image_point_in_class의 x, y값
   
  
   public static BufferedImage go_cropped() {
      return cropped_img;
   }
   
   public static BufferedImage go_zoomed() {
      return zoomed_img;
   }
   
   @Override
   public void mouseClicked(MouseEvent e) { // 원본이미지 내에 아무데나 클릭하면, 해당 이미지 내에서의 좌표가 계산된다.
      // TODO Auto-generated method stub
      
      cropped_img = MyActionListener.resize(MainFrame_Second.empty_image2, 30, 30);
      zoomed_img = MyActionListener.resize(MainFrame_Second.empty_image2, 100, 100);
      
      if (MainFrame_Second.zoom_button_clicked_count % 2 == 1) { // zoom_button이 눌렸을 때만 실행됨
         
         image_point_in_MouseListener = e.getPoint();
         x = (int)image_point_in_MouseListener.getX();
         y = (int)image_point_in_MouseListener.getY();
         
         
         if(x < 30) { // 마우스로 클릭한 곳이 너무 왼쪽 끝이면 (너비 기준)
            x = 30;
         }
         else if (x > MainFrame_Second.changeImage.getWidth()-30 ) { // 마우스로 클릭한 곳이 너무 오른쪽 끝이면 (너비 기준)
            x = MainFrame_Second.changeImage.getWidth()-30;
         }
         else if (y < 30) { // 마우스로 클릭한 곳이 너무 윗쪽이면 (높이 기준)
            y = 30;
         }
         else if (y > MainFrame_Second.changeImage.getHeight()-30 ) { // 마우스로 클릭한 곳이 너무 아래쪽이면 (높이 기준)
            y = MainFrame_Second.changeImage.getHeight()-30;
         }
         
         
         // BufferedImage 클래스의 getSubimage() : 이미지 자르는 함수
         cropped_img = MainFrame_Second.changeImage.getSubimage(x-15, y-15, 30, 30); // (x-15, y-15)위치에서 가로 30, 세로 30만큼 잘라온다.
                     
         // 이미지를 확대하는 함수 (하단에 구현)
         zoomed_img = resize(cropped_img, 100, 100);

         count++;
         go_cropped();
         go_zoomed();
         
         MainFrame_Second.get2.setIcon(new ImageIcon(cropped_img));
         MainFrame_Second.get3.setIcon(new ImageIcon(zoomed_img));
         //System.out.println("돋보기 버튼 활성화 중에 사진이 클릭된 횟수 :" + count);
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

   // 이미지 확대 함수
   static BufferedImage resize(BufferedImage img, int for_resized_Width, int for_resized_Height) {  
      
      int w = img.getWidth(); // 너비
      int h = img.getHeight(); // 높이
      BufferedImage zoomed_img = new BufferedImage(for_resized_Width, for_resized_Height, img.getType());  
          
      /* Graphics클래스 : 그래픽 개체를 만들 수 있음
          단, Graphics 개체를 사용할 때마다 CreateGraphics를 호출한 다음, 사용을 마친 후에는 Dispose를 호출해야 한다.*/
      Graphics2D g = zoomed_img.createGraphics();
          
      /* RenderingHints클래스 : 다양한 보간법을 지원한다. (Bilinear, Bicubic 등)
         이미지 확대시 생기는 픽셀깨짐(앨리어싱 느낌?)을 개선해줌. */
      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC); //BILINEAR);
          
      /* http://blog.daum.net/clamp83/56
         drawImage() : 이미지의 부분영역을 그릴 수 있음. 또는 확대/축소도 가능.
         g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer) : 이미지 img의 (sx1, sy1, sx2, sy2)영역을 (dx1, dy1, dx2, dy2)영역에 그린다. */
      g.drawImage(img, 0, 0, for_resized_Width, for_resized_Height, 0, 0, w, h, null);
      g.dispose();
          
      return zoomed_img;
   }
   
}



//두 번째 프레임 끝 


//메인 함수
public class project {
    public static void main(String[] args) {
    
        new MainFrame_One();
       

    }
}