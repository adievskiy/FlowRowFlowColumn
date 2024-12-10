package com.example.flowrowflowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val employees = mutableStateListOf(
            Employees("Первый", "Первов", "Инженер", 35000.00),
            Employees("Второй", "Второв", "Механик", 35000.00),
            Employees("Третий", "Третьеров", "Бухгалтер", 35000.00),
            Employees("Четвертый", "Четверов", "Бухгалтер", 35000.00),
            Employees("Пятый", "Пятов", "Механик", 35000.00),
            Employees("Шестой", "Шестов", "Инженер", 35000.00),
            Employees("Седьмой", "Седьмов", "Инженер", 35000.00),
            Employees("Восьмой", "Восьмов", "Механик", 35000.00),
            Employees("Девятый", "Девятов", "Инженер", 35000.00),
            Employees("Десятый", "Десятов", "Механик", 35000.00),
            Employees("Одиннадцатый", "Одиннадцатов", "Инженер", 35000.00),
            Employees("Двенадцатый", "Двенадцатов", "Бухгалтер", 35000.00),
        )

        val sortedEmployees = employees.sortedWith(compareBy({ it.name }, { it.position }))

        setContent {
            Surface {
                EmployeeList(sortedEmployees)
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EmployeeList(employees: List<Employees>) {
    androidx.compose.foundation.layout.FlowColumn(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(top = 45.dp),
        maxItemsInEachColumn = 3,
        verticalArrangement = Arrangement.Center,

    ) {
        for (employee in employees) {
            EmployeeCard(employee)
        }
    }
}

@Composable
fun EmployeeCard(employee: Employees) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .height(100.dp)
            .background(color = Color.DarkGray)
            .border(width = 3.dp, color = Color.Black),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${employee.name} ${employee.surname}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = employee.position, fontSize = 14.sp)
            Text(
                text = "Зарплата: ${employee.salary} руб.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

data class Employees(
    val name: String,
    val surname: String,
    val position: String,
    val salary: Double,
)