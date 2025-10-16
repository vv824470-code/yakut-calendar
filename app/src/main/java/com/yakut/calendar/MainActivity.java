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
        
        // Загрузка улучшенного HTML контента с днями
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
                "body{font-family:Arial,sans-serif;background:linear-gradient(135deg,#1e3c72 0%,#2a5298 100%);color:#333;min-height:100vh;padding:10px}" +
                ".container{max-width:1200px;margin:0 auto;background:rgba(255,255,255,0.98);border-radius:15px;padding:15px;box-shadow:0 8px 25px rgba(0,0,0,0.2)}" +
                "header{text-align:center;margin-bottom:20px;padding-bottom:10px;border-bottom:2px solid #2a5298}" +
                "h1{color:#1e3c72;font-size:1.6em;margin-bottom:8px}" +
                ".subtitle{color:#666;font-style:italic;margin-bottom:15px}" +
                ".season-section{margin-bottom:25px}" +
                ".season-title{color:#1e3c72;font-size:1.4em;margin:15px 0;padding:8px 15px;background:linear-gradient(90deg,#667eea,transparent);border-radius:8px}" +
                ".calendar-grid{display:grid;grid-template-columns:repeat(auto-fit,minmax(300px,1fr));gap:12px;margin-bottom:20px}" +
                ".month-card{background:linear-gradient(135deg,#667eea 0%,#764ba2 100%);border-radius:12px;padding:12px;color:white;transition:transform 0.3s}" +
                ".month-card:active{transform:scale(0.98)}" +
                ".month-header{display:flex;justify-content:space-between;align-items:center;margin-bottom:8px;padding-bottom:6px;border-bottom:1px solid rgba(255,255,255,0.3)}" +
                ".month-name{font-weight:bold;font-size:1.1em}" +
                ".month-num{background:rgba(255,255,255,0.2);padding:2px 8px;border-radius:8px;font-size:0.8em}" +
                ".month-details{font-size:0.85em;line-height:1.4}" +
                ".days-list{margin-top:8px;font-size:0.8em;background:rgba(255,255,255,0.1);padding:6px;border-radius:6px}" +
                ".day-item{margin-bottom:3px;padding-left:8px;position:relative}" +
                ".day-item:before{content:'•';position:absolute;left:0;color:#fff}" +
                ".current-day{background:rgba(255,255,255,0.3);border-radius:4px;padding:2px 4px;font-weight:bold}" +
                "@media (max-width:480px){.container{padding:8px}h1{font-size:1.3em}.calendar-grid{grid-template-columns:1fr}.month-card{padding:10px}}" +
                "</style></head>" +
                "<body><div class='container'><header><h1>🗓️ Якутский Календарь</h1><div class='subtitle'>Саха эргээрдээх халааннара - Традиционный годовой цикл</div></header>" +
                
                // Весна
                "<div class='season-section'><div class='season-title'>🌱 Весна (Саас) - Возрождение</div><div class='calendar-grid'>" +
                getMonthCard("Ыам ыйа", "1", "Май", "Месяц богатырской силы", "🎉 Начало нового года, Ысыах", "1-5: Подготовка к празднику\n6-15: Празднование Ысыах\n16-30: Таяние снега, вскрытие рек") +
                getMonthCard("Бэс ыйа", "2", "Июнь", "Месяц сосны и зелени", "🌿 Пробуждение природы", "1-10: Белые ночи\n11-20: Цветение растений\n21-30: Начало охоты и рыбалки") +
                getMonthCard("От ыйа", "3", "Июль", "Месяц травы и сена", "☀️ Пик лета, сенокос", "1-15: Самый жаркий период\n16-25: Начало сенокоса\n26-31: Заготовка трав") +
                "</div></div>" +
                
                // Лето
                "<div class='season-section'><div class='season-title'>🌞 Лето (Сайын) - Изобилие</div><div class='calendar-grid'>" +
                getMonthCard("Атырдьах ыйа", "4", "Август", "Месяц скирдования", "🌾 Уборка урожая", "1-10: Сбор ягод и грибов\n11-20: Скирдование сена\n21-31: Заготовка на зиму") +
                "</div></div>" +
                
                // Осень
                "<div class='season-section'><div class='season-title'>🍂 Осень (Күһүн) - Подготовка</div><div class='calendar-grid'>" +
                getMonthCard("Балаҕан ыйа", "5", "Сентябрь", "Месяц, когда лоси ревут", "🍂 Начало охотничьего сезона", "1-10: Золотая осень\n11-20: Рёв лосей, листопад\n21-30: Заготовка рыбы и мяса") +
                getMonthCard("Алтынньы", "6", "Октябрь", "Месяц привязывания собак", "❄️ Первые морозы", "1-15: Первый снег\n16-25: Замерзание рек\n26-31: Подготовка к зиме") +
                getMonthCard("Сэтинни", "7", "Ноябрь", "Месяц утренних заморозков", "🏔️ Начало зимы", "1-10: Установление снежного покрова\n11-20: Зимняя охота\n21-30: Короткие дни") +
                "</div></div>" +
                
                // Зима
                "<div class='season-section'><div class='season-title'>❄️ Зима (Кыһын) - Созерцание</div><div class='calendar-grid'>" +
                getMonthCard("Ахсынньы", "8", "Декабрь", "Месяц холода", "🌌 Самые длинные ночи", "1-10: Короткие дни\n11-20: Домашние ремесла\n21-31: Подготовка к Новому году") +
                getMonthCard("Тохсунньу", "9", "Январь", "Месяц застывания", "🥶 Самые сильные морозы", "1-15: Сильные морозы\n16-25: Расчистка снега\n26-31: Уход за скотом") +
                getMonthCard("Олунньу", "10", "Февраль", "Месяц снежных заносов", "🌪️ Снежные бури и метели", "1-14: Снежные бури\n15-28: Подготовка к весне") +
                getMonthCard("Кулун тутар", "11", "Март", "Месяц жеребения кобылиц", "🐎 Рождение жеребят", "1-10: Первые признаки весны\n11-20: Жеребение кобылиц\n21-31: Подготовка к отелу") +
                getMonthCard("Муус устар", "12", "Апрель", "Месяц таяния льда", "💧 Таяние льда, ледоход", "1-15: Таяние снега\n16-25: Ледоход на реках\n26-30: Подготовка к лету") +
                "</div></div>" +
                
                "<footer style='text-align:center;color:#666;margin-top:25px;padding-top:12px;border-top:2px solid #1e3c72;font-size:0.9em'>" +
                "📅 Традиционный календарь народа Саха • 🌍 Гармония с природой • 🕰️ Мудрость предков" +
                "</footer></div>" +
                "<script>" +
                "function updateCurrentDay() {" +
                "  const now = new Date();" +
                "  const day = now.getDate();" +
                "  document.querySelectorAll('.day-item').forEach(item => {" +
                "    if(item.textContent.includes(day + ':')) {" +
                "      item.classList.add('current-day');" +
                "    }" +
                "  });" +
                "}" +
                "document.addEventListener('DOMContentLoaded', updateCurrentDay);" +
                "</script>" +
                "</body></html>";
    }

    private String getMonthCard(String name, String num, String greg, String meaning, String feature, String days) {
        String daysHtml = "<div class='days-list'>";
        String[] dayLines = days.split("\n");
        for (String dayLine : dayLines) {
            daysHtml += "<div class='day-item'>" + dayLine + "</div>";
        }
        daysHtml += "</div>";
        
        return "<div class='month-card'>" +
                "<div class='month-header'>" +
                "<div class='month-name'>" + name + "</div>" +
                "<div class='month-num'>" + num + "</div>" +
                "</div>" +
                "<div class='month-details'>" +
                "<div><strong>" + greg + "</strong> - " + meaning + "</div>" +
                "<div style='margin:5px 0; font-size:0.8em'>" + feature + "</div>" +
                daysHtml +
                "</div>" +
                "</div>";
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
