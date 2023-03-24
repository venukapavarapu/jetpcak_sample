package com.example.jetpcaksample.ui.theme

class Sample {
    fun main(){
        val v : List<Student> = get() as List<Student>
        var map : MutableMap<Course,Int> = HashMap()
        var mapp : MutableMap<Course,Int> = HashMap()
        var a : Int= 0
        get().forEach {
            val sc = it.subscribedCourses
            sc.forEach {c->
                if(c.isPaid){
                    if(map.containsKey(c)){
                        map[c] = (map[c] ?: 1) + 1
                    }
                    else map[c] = 1
                }
            }
        }

        val m = map.toSortedMap(compareByDescending {
            map[it]
        })

            val it: MutableIterator<Map.Entry<Course,Int>> = map.entries.iterator()
            while (it.hasNext()) {
                val (key) = it.next()
            }

        map.forEach {
            if(a > 6){
                mapp[it.key] = it.value
            }
        }
    }


    fun get() : Iterable<Student>{

        val s1=Student(subscribedCourses = listOf(Course(name = "Maths", isPaid = false, id = 1),
            Course(name = "Arts", isPaid = true, id = 2)),id =1, name = "")

        val s2=Student(subscribedCourses = listOf(Course(name = "History", isPaid = true,id=1),
            Course(name = "Biology", isPaid = true,id=2)),id =2, name = "")

        val s3=Student(subscribedCourses = listOf(Course(name = "Physics", isPaid = true,id=1),
            Course(name = "History", isPaid = true,id=2)),id =2, name = "")

        return listOf<Student>(s1,s2,s3)

    }
}


data class Student(val id: Int, val name: String, val subscribedCourses: List<Course>)

data class Course(val id: Int, val name: String, val isPaid: Boolean)

