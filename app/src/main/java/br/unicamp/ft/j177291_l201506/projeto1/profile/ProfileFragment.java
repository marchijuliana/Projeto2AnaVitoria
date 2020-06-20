package br.unicamp.ft.j177291_l201506.projeto1.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.unicamp.ft.j177291_l201506.projeto1.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    CircleImageView profile_image;
    TextView username;

    DatabaseReference reference;
    FirebaseUser firebaseUser;

    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profile_image = view.findViewbyId(R.id.profile_image); //achar o id certo
        username = view.findViewById(R.id.profile_user);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference(S: "Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                    User user = dataSnapshot.getValue(User.class);
                    username.setText(user.getusername());
                    if(user.getImageURL().equals("default")){
                        profile_image.setImageResource(R.mipmap.ic_launcher)
                    } else {
                        Glide.with(getContext()).load(user.getImageURL()).into(profile_image);
                    }
        }

        @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })

        return view;
    }
}

/*
REAUTENTICAR USUARIO FIREBASE
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
AuthCredential credential = EmailAuthProvider
        .getCredential("user@example.com", "password1234");

// Prompt the user to re-provide their sign-in credentials
user.reauthenticate(credential)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d(TAG, "User re-authenticated.");
            }
        });
* */