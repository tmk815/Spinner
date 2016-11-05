import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //項目の追加
        adapter1.add("漢字");
        adapter1.add("ひらがな");
        adapter1.add("カタカナ");

        final Spinner sp1=(Spinner)findViewById(R.id.sp1);
        final Spinner sp2=(Spinner)findViewById(R.id.sp2);

        //アダプターのセット
        sp1.setAdapter(adapter1);

        //スピナーの内容選択時に呼び出されるコールバックリスナーを登録
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                
                //この１行を追加
                adapter2.clear();
                
                // 選択されたアイテムを取得します
                String item = (String) spinner.getSelectedItem();
                if (item.equals("漢字")){
                    adapter2.add("春");
                    adapter2.add("夏");
                    adapter2.add("秋");
                    adapter2.add("冬");
                    sp2.setAdapter(adapter2);
                }else if (item.equals("ひらがな")){
                    adapter2.add("はる");
                    adapter2.add("なつ");
                    adapter2.add("あき");
                    adapter2.add("ふゆ");
                    sp2.setAdapter(adapter2);
                }else if (item.equals("カタカナ")){
                    adapter2.add("ハル");
                    adapter2.add("ナツ");
                    adapter2.add("アキ");
                    adapter2.add("フユ");
                    sp2.setAdapter(adapter2);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
}
