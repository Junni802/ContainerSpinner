package com.example.containerspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		
		var data = listOf("- 선택하세요 -", "1월", "2월", "3월", "4월", "5월", "6월")
		// spinner에 넣을 아이템 생성
		var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
		// data와 spinner를 연결해줄 ArrayAdapter 인스턴스 생성
		// this : spinner를 화면에 보이기 위한 컨텍스트
		// simple_list_item1 : 1개의 문자열을 가져와 레이아웃에 보여줌
		// data : spinner에서 보여줄 아이템 목록
		
		binding.spinner.adapter = adapter	// spinner에 어뎁터를 연결해줌

		binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
			override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
			// p2 : 사용자가 선택한 아이템의 인덱스 번호(0부터 시작)로 p3도 동일한 값이며 대부분 p2값만 사용함
				Log.d("spinnerwo", "${data[p2]}")

				binding.result.text = data[p2]


			}

			override fun onNothingSelected(p0: AdapterView<*>?) {
				
			}
		}
	}
}