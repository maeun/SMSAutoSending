package com.maeun.smsautosending

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import com.fondesa.kpermissions.extension.listeners
import com.fondesa.kpermissions.extension.permissionsBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = permissionsBuilder(Manifest.permission.SEND_SMS).build()
        request.send()
        request.listeners {
            onAccepted {
                Toast.makeText(applicationContext, "accepted", Toast.LENGTH_SHORT).show()
            }
            onDenied {
                Toast.makeText(applicationContext, "denied", Toast.LENGTH_SHORT).show()
            }
        }

        var textDinner = arrayOf("저녁 먹고 가요", "저녁하고 들어가요", "저녁 먹고 있어요", "저녁 먹고 갑니다", "지금 저녁 먹어요", "저녁 먹기 전에 연락드려요", "저녁 먹고 가려고요")
        var textHome = arrayOf("출발해요", "집 가려고요", "들어가는 길이에요", "이제 집 가요", "이제 집에 가요", "막 출발했어요", "들어가려고요", "집에 가려고요", "이제 집에 갑니다")

//        val dinnerRandomText = textDinner[Random().nextInt(textDinner.size)]
//        val homeRandomText = textHome[Random().nextInt(textHome.size)]

//        BtnDinner.setOnClickListener{
//            Toast.makeText(this, dinnerRandomText, Toast.LENGTH_LONG).show();
//        }
//
//        BtnHome.setOnClickListener{
//            Toast.makeText(this, homeRandomText, Toast.LENGTH_LONG).show();
//        }

        BtnDinner.setOnClickListener{
            SmsManager.getDefault().sendTextMessage("###",null,textDinner[Random().nextInt(textDinner.size)],null,null)
            Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show()
        }

        BtnHome.setOnClickListener{
            SmsManager.getDefault().sendTextMessage("###",null,textHome[Random().nextInt(textHome.size)],null,null)
            Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show()}


//            val phoneNo = "01093881124"
//
//                try {
//                    //전송
//                    val smsManager = SmsManager.getDefault()
//                    smsManager.sendTextMessage(phoneNo, null, dinnerRandomText, null, null)
//                    Toast.makeText(applicationContext, "전송 완료!", Toast.LENGTH_LONG).show()
//                } catch (e: Exception) {
//                    Toast.makeText(applicationContext, "SMS faild, please try again later!", Toast.LENGTH_LONG).show()
//                    e.printStackTrace()
//                }

            }

}
