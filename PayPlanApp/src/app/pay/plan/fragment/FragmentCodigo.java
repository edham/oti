package app.pay.plan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.pay.plan.ui.R;

public class FragmentCodigo extends Fragment {

//        private Spinner ComboCodigo;
//        private String[] listCodigo;
//        private Bitmap bitmap = null;
//        private EditText txtCodigo;
//        private View ImagenView;
//        private Button btnGenerar;
//
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//
		View view = inflater.inflate(R.layout.fragment_layout_one, container,
				false);
//
//                btnGenerar = (Button) view.findViewById(R.id.btnGenerar);
//                btnGenerar.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        btnGenerar();
//                    }
//                });      
//		ImagenView = (View) view.findViewById(R.id.ImagenView);
//                txtCodigo = (EditText) view.findViewById(R.id.txtCodigo);
//                ComboCodigo = (Spinner)view.findViewById(R.id.ComboCodigo);
//
//                listCodigo=getResources().getStringArray(R.array.array_codigo);
//                ArrayAdapter<String> adapterSexo = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,listCodigo);       
//                adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_item);
//                ComboCodigo.setAdapter(adapterSexo); 
//                ComboCodigo.setSelection(0);
//                
		return view;
	}
//
//        public void btnGenerar()
//  {
//      if(!txtCodigo.getText().toString().equals("") &&  !txtCodigo.getText().toString().equals(null))
//        try {
//            if(ComboCodigo.getSelectedItemPosition()==0)
//            bitmap=generateQR(txtCodigo.getText().toString(),200,200);
//            else
//                bitmap=generateBarras(txtCodigo.getText().toString(),200,200);
//            Drawable d = new BitmapDrawable(getResources(),bitmap);
//            ImagenView.setBackgroundDrawable(d);
//            txtCodigo.setText("");
//            
//                   
//        } catch (Exception ex) {
////            Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      else
//          Toast.makeText(this.getActivity(),getString(R.string.str_escriba_texto), Toast.LENGTH_LONG).show();
//  }
//       
//       
//        public Bitmap generateQR(String text, int h, int w) throws Exception {
// 
//        Charset charset = Charset.forName("ISO-8859-1");
//        CharsetEncoder encoder = charset.newEncoder();
//        byte[] b = null;
//        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(text));
//        b = bbuf.array();
//        String data = new String(b, "ISO-8859-1");
//        // get a byte matrix for the data
//        
//        
//        BitMatrix matrix = null;
//        QRCodeWriter writer = new QRCodeWriter();
//        matrix = writer.encode(data, com.google.zxing.BarcodeFormat.QR_CODE, w, h);
//
//        
//        int height = matrix.getHeight();
//        int width = matrix.getWidth();
//        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
//            for (int x = 0; x < width; x++){
//                for (int y = 0; y < height; y++){
//                    bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
//                }
//            }
//    
//        return bmp;
//
//    }
//       
//       
//       public Bitmap generateBarras(String text, int h, int w) throws Exception {
// 
//        Charset charset = Charset.forName("ISO-8859-1");
//        CharsetEncoder encoder = charset.newEncoder();
//        byte[] b = null;
//        ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(text));
//        b = bbuf.array();
//        String data = new String(b, "ISO-8859-1");
//        // get a byte matrix for the data
//        
//        
//        BitMatrix matrix = null;
//        
//        matrix = new Code128Writer().encode(data, BarcodeFormat.CODE_128, w, h, null);
//
//        
//        int height = matrix.getHeight();
//        int width = matrix.getWidth();
//        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
//            for (int x = 0; x < width; x++){
//                for (int y = 0; y < height; y++){
//                    bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
//                }
//            }
//    
//        return bmp;
//
//    }
}
