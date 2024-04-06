package com.aviva.scopefunctions

// Android imports
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// AndroidX imports
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Nullable integer variable
    private var number: Int? = null

    // This variable is used to store the result of the 'also' scope function
    private var alsoResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Set the content view
        setContentView(R.layout.activity_main)

        // Set window insets listener
        setWindowInsetsListener()

        // Handle nullable variable using 'let' scope function
        letScopeExample()

        // Handle variable using 'also' scope function
        alsoScopeExample()

        // Handle variable using 'apply' scope function
        applyScopeExample()

        // Handle variable using 'run' scope function
        runScopeExample()

        // Handle variable using 'with' scope function
        withScopeExample()

    }

    /**
     * Sets an OnApplyWindowInsetsListener on the main view.
     * This listener adjusts the padding of the view to match the insets of the system bars.
     */
    private fun setWindowInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /**
     * Handles a nullable variable using the 'let' scope function.
     * If the variable 'number' is not null, its value is doubled and assigned to 'letResult'.
     * If 'number' is null, 'letResult' is assigned the value 0.
     */
    private fun letScopeExample() {
        val letResult = number?.let {
            val doubledNumber = it * 2
            doubledNumber
        } ?: 0
    }

    /**
     * This function calculates the square of 'alsoResult' and increments 'alsoResult' by one.
     * The 'also' scope function is used to perform the increment operation.
     * The function returns the square of 'alsoResult'.
     */
    private fun alsoScopeExample() = (alsoResult * alsoResult).also {
        alsoResult++
    }


    /**
     * This function demonstrates the use of the 'apply' scope function.
     * The 'apply' scope function is used to set multiple properties of an object.
     * In this example, the 'apply' scope function is used to set multiple properties of an Intent object.
     */
    private fun applyScopeExample() {
        Intent().apply {
            putExtra("key1", "value")
            putExtra("key2", 0)
        }
    }

    /**
     * This function demonstrates the use of the 'run' scope function.
     * The 'run' scope function is used to execute a block of code on an object.
     * In this example, the 'run' scope function is used to set multiple properties of an Intent object.
     */
    private fun runScopeExample() {
        Intent().run {
            putExtra("key1", "value")
            putExtra("key2", 0)
        }
    }


    /**
     * This function demonstrates the use of the 'with' scope function.
     * The 'with' scope function is used to execute a block of code on an object.
     * In this example, the 'with' scope function is used to set multiple properties of an Intent object.
     */

    private fun withScopeExample() {
        val intent = Intent()
        with(intent) {
            putExtra("key1", "value")
            putExtra("key2", 0)
        }
    }
}