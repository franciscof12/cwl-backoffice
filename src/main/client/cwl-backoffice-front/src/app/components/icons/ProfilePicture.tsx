import Image from "next/image";

function ProfilePicture() {
    return (
        <Image
            src="/user.png"
            width={35}
            height={35}
            alt="Picture of the trovit logo"
            className=' rounded-full'
        />
    );
}

export default ProfilePicture;
