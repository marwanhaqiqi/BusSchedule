package com.example.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.busschedule.ui.theme.BusScheduleTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusScheduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusScheduleScreen()
                }
            }
        }
    }
}

@Composable
fun BusScheduleScreen() {
    // Data untuk jadwal bus (bisa diganti dengan data dinamis nantinya)
    val busStops = listOf(
        BusStop("Example Street", "7:00 PM"),
        BusStop("Main Street", "7:15 PM"),
        BusStop("Central Park", "7:30 PM")
    )

    // Tampilan kolom untuk jadwal bus
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Bus Schedule",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Menampilkan daftar jadwal bus
        for (busStop in busStops) {
            ScheduleRow(busStop)
        }
    }
}

@Composable
fun ScheduleRow(busStop: BusStop) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = busStop.stopName, fontSize = 18.sp)
        Text(text = busStop.arrivalTime, fontSize = 18.sp)
    }
}

// Preview untuk menampilkan tampilan di editor
@Preview(showBackground = true)
@Composable
fun BusSchedulePreview() {
    BusScheduleTheme {
        BusScheduleScreen()
    }
}

// Data class untuk setiap bus stop
data class BusStop(val stopName: String, val arrivalTime: String)
