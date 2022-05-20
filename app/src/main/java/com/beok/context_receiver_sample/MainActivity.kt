package com.beok.context_receiver_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sort()
    }

    private fun sort() {
        with(Comparator.naturalOrder<Int>()) {
            listOf(3, 5, 1).sort()
        }
        Comparator.naturalOrder<Int>().run {
            listOf(3, 5, 1).sort()
        }
        listOf(3, 5, 1).sortedWith(Comparator.naturalOrder())
    }

    private fun transfer() {
        val service = AccountService()
        val transaction = Transaction()
        val repo = AccountRepo()

        /* 일반적인 호출 방식 */
//        service.transfer(
//            transaction,
//            { repo.credit(Account("a"), 10.5) },
//            { repo.credit(Account("b"), 10.5) }
//        )

        /* 확장 함수 활용 */
//        with(service) {
//            transaction.transfer(
//                { repo.credit(Account("a"), 10.5) },
//                { repo.credit(Account("b"), 10.5) }
//            )
//        }

        /* context 활용 */
        with(transaction) {
            service.transfer(
                { repo.credit(Account("a"), 10.5) },
                { repo.credit(Account("b"), 10.5) }
            )
        }
    }
}
