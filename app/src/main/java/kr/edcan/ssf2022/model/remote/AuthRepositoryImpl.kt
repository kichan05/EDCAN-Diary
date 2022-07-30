package kr.edcan.ssf2022.model.remote

import android.net.Uri
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import kr.edcan.ssf2022.model.data.User
import kr.edcan.ssf2022.util.Result
import kr.edcan.ssf2022.util.Collection

class AuthRepositoryImpl : AuthRepository {
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val db : FirebaseFirestore = FirebaseFirestore.getInstance()
    private val storage : FirebaseStorage = FirebaseStorage.getInstance()
    
    override suspend fun register(userData: User, password: String): Int {
        /*
        * 회원가입을 진행하는 함수
        * firebase의 유저를 만들고, 유저 정보를 저장하고, 프로필 이미지를 업로드 한다.
        * createUser, saveUserData, uploadProfileImage 함수 실행
        * */

        val createUserResult = createUser(userData, password)
        if(createUserResult == Result.FAILED)
            return Result.FAILED

        val saveUserData = saveUserData(userData)
        if(saveUserData == Result.FAILED)
            return Result.FAILED

        // TODO("프로필 사진 업로드 기능 만들기")

        return Result.SUCCESS
    }

    override suspend fun createUser(userData: User, password: String): Int {
        /*
        * Firebase Auth에 계정을 만드는 함수
        * */
        var result = Result.FAILED
        auth.createUserWithEmailAndPassword(userData.email, password)
            .addOnSuccessListener {
                result = Result.SUCCESS
            }
            .await()

        return result
    }

    override suspend fun saveUserData(userData: User): Int {
        /*
        * Firebase Forestore에 계정 정보를 저장하는 함수 
        * */
        var result = Result.FAILED
        db.collection(Collection.auth).document(userData.email)
            .set(userData)
            .addOnSuccessListener {
                result = Result.SUCCESS
            }
            .await()

        return result
    }

    override suspend fun uploadProfileImage(userData: User, profileImage: Uri): Int {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): User? {
        /*
        * 로그인을 진행하는 함수
        * 사용자가 입력한 이메일에 해당하는 사용자 정보를 가져온다.
        * 사용자 정보가 없다면 로그인을 진행하지 않는다
        * 사용자 정보가 있으면 로그인을 진행한다.
        * */
        var userData : User? = getUserDataByEmail(email) ?: null;

        auth.signInWithEmailAndPassword(email, password)
            .addOnFailureListener {
                Log.e("[login error]", "${it.message}")
                userData = null
            }
            .await()


        return userData
    }

    override suspend fun getUserDataByEmail(email: String): User? {
        var result : User? = null

        db.collection(Collection.auth).document(email).get()
            .addOnSuccessListener {
                result = it.toObject(User::class.java)
            }
            .await()

        return result
    }
}