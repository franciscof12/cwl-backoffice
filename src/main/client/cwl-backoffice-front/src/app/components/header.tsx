import Image from 'next/image'
import Trovitblue from "@/app/components/icons/Trovitblue";
import ProfilePicture from "@/app/components/icons/ProfilePicture";

export default function Header() {
    return (
        <div className="p-10 h-full w-full items-center flex justify-between">
            <Trovitblue/>
            <div className='flex-row flex gap-2 items-center justify-end'>
                <ProfilePicture/>
                <p className='text-base text-color-ui-crema_black'>Francisco Ferreira</p>
            </div>
        </div>
    )
}