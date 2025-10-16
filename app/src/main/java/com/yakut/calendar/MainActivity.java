package com.yakut.calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        
        // Загрузка HTML контента
        String htmlContent = getHTMLContent();
        webView.loadDataWithBaseURL("file:///android_asset/", htmlContent, "text/html", "UTF-8", null);
    }

    private String getHTMLContent() {
        return "<!DOCTYPE html>" +
                "<html lang='ru'>" +
                "<head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>Якутский Календарь</title>" +
                "<style>" +
                "*{margin:0;padding:0;box-sizing:border-box}" +
                "body{font-family:Arial,sans-serif;background:linear-gradient(135deg,#1e3c72 0%,#2a5298 100%);color:#333;min-height:100vh;padding:20px}" +
                ".container{max-width:1200px;margin:0 auto;background:rgba(255,255,255,0.95);border-radius:20px;padding:20px;box-shadow:0 10px 30px rgba(0,0,0,0.3)}" +
                "header{text-align:center;margin-bottom:30px;padding-bottom:15px;border-bottom:3px solid #2a5298}" +
                "h1{color:#1e3c72;font-size:1.8em;margin-bottom:10px}" +
                ".subtitle{color:#666;font-style:italic}" +
                ".calendar-grid{display:grid;grid-template-columns:repeat(auto-fit,minmax(280px,1fr));gap:15px;margin-bottom:30px}" +
                ".month-card{background:linear-gradient(135deg,#667eea 0%,#764ba2 100%);border-radius:15px;padding:15px;color:white;transition:transform 0.3s}" +
                ".month-card:active{transform:scale(0.98)}" +
                ".month-header{display:flex;justify-content:space-between;margin-bottom:10px;padding-bottom:8px;border-bottom:1px solid rgba(255,255,255,0.3)}" +
                ".month-name{font-weight:bold;font-size:1.2em}" +
                ".month-num{background:rgba(255,255,255,0.2);padding:2px 8px;border-radius:10px;font-size:0.9em}" +
                "@media (max-width:480px){.container{padding:10px}h1{font-size:1.5em}.calendar-grid{grid-template-columns:1fr}}" +
                "</style></head>" +
                "<body><div class='container'><header><h1>Якутский Календарь</h1><div class='subtitle'>Саха эргээрдээх халааннара</div></header><div class='calendar-grid'>" +
                
                // Весна
                "<div class='month-card'><div class='month-header'><div class='month-name'>Ыам ыйа</div><div class='month-num'>1</div></div><div>Май - Месяц богатырской силы</div><div style='font-size:0.9em;margin-top:5px'>🎉 Начало нового года</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Бэс ыйа</div><div class='month-num'>2</div></div><div>Июнь - Месяц сосны</div><div style='font-size:0.9em;margin-top:5px'>🌿 Пробуждение природы</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>От ыйа</div><div class='month-num'>3</div></div><div>Июль - Месяц травы</div><div style='font-size:0.9em;margin-top:5px'>☀️ Пик лета</div></div>" +
                
                // Лето
                "<div class='month-card'><div class='month-header'><div class='month-name'>Атырдьах ыйа</div><div class='month-num'>4</div></div><div>Август - Месяц скирдования</div><div style='font-size:0.9em;margin-top:5px'>🌾 Уборка урожая</div></div>" +
                
                // Осень
                "<div class='month-card'><div class='month-header'><div class='month-name'>Балаҕан ыйа</div><div class='month-num'>5</div></div><div>Сентябрь - Месяц, когда лоси ревут</div><div style='font-size:0.9em;margin-top:5px'>🍂 Начало охотничьего сезона</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Алтынньы</div><div class='month-num'>6</div></div><div>Октябрь - Месяц привязывания собак</div><div style='font-size:0.9em;margin-top:5px'>❄️ Первые морозы</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Сэтинни</div><div class='month-num'>7</div></div><div>Ноябрь - Месяц заморозков</div><div style='font-size:0.9em;margin-top:5px'>🏔️ Начало зимы</div></div>" +
                
                // Зима
                "<div class='month-card'><div class='month-header'><div class='month-name'>Ахсынньы</div><div class='month-num'>8</div></div><div>Декабрь - Месяц холода</div><div style='font-size:0.9em;margin-top:5px'>🌌 Самые длинные ночи</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Тохсунньу</div><div class='month-num'>9</div></div><div>Январь - Месяц застывания</div><div style='font-size:0.9em;margin-top:5px'>🥶 Самые сильные морозы</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Олунньу</div><div class='month-num'>10</div></div><div>Февраль - Месяц снежных заносов</div><div style='font-size:0.9em;margin-top:5px'>🌪️ Снежные бури</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Кулун тутар</div><div class='month-num'>11</div></div><div>Март - Месяц жеребения</div><div style='font-size:0.9em;margin-top:5px'>🐎 Рождение жеребят</div></div>" +
                "<div class='month-card'><div class='month-header'><div class='month-name'>Муус устар</div><div class='month-num'>12</div></div><div>Апрель - Месяц таяния льда</div><div style='font-size:0.9em;margin-top:5px'>💧 Таяние льда</div></div>" +
                
                "</div><footer style='text-align:center;color:#666;margin-top:20px;padding-top:15px;border-top:2px solid #1e3c72'>Традиционный календарь народа Саха • Мудрость предков • Гармония с природой</footer></div></body></html>";
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
