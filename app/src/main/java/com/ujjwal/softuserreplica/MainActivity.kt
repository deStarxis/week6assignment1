package com.ujjwal.softuserreplica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ujjwal.softuserreplica.`object`.student
import com.ujjwal.softuserreplica.fragments.AboutUsFragment
import com.ujjwal.softuserreplica.fragments.AddStudentFragment
import com.ujjwal.softuserreplica.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var linearFragment : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        linearFragment=findViewById(R.id.linearFragment)
        val firstFragment=HomeFragment()
        val secondFragment=AddStudentFragment()
        val thirdFragment=AboutUsFragment()
        student.addStudent()
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    setCurrentFragment(firstFragment)
                    true
                }
                R.id.addStudent->{
                    setCurrentFragment(secondFragment)
                    true
                }
                R.id.aboutUs->{
                    setCurrentFragment(thirdFragment)
                    true
                }
                else -> false
            }
        }
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home->{
                    setCurrentFragment(firstFragment)
                    true
                }
                R.id.addStudent->{
                    setCurrentFragment(secondFragment)
                    true
                }
                R.id.aboutUs->{
                    setCurrentFragment(thirdFragment)
                    true
                }
                else -> false
            }
        }
    }
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearFragment, fragment)
            commit()
        }
    }
}