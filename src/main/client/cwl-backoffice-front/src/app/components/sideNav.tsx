'use client'
import Image from 'next/image'
import Link from 'next/link'
import {usePathname} from "next/navigation";
import BookIcon from "@/app/components/icons/BookIcon";
import SourceIcon from "@/app/components/icons/SourceIcon";
import Xicon from "@/app/components/icons/XIcon";
import LifullWhiteLogo from "@/app/components/icons/LifullWhiteLogo";

export default function SideNav() {
    const pathname = usePathname()
    return (
        <>
            <div className='pb-14 pl-4 pt-8 justify-start items-center flex gap-2'>
                <LifullWhiteLogo /> <strong className='text-color-ui-crema_white font-semibold text-4xl'>Dashboard</strong>
            </div>
            <ul className="p-4 gap-y-2 flex flex-col">
                <Link href="/dashboard"
                      className={`flex text-color-ui-crema_white flex-row items-center justify-start gap-2 font-semibold p-1 rounded-md bg-neutral-600/30 pl-4 hover:bg-neutral-400/80 hover:text-color-ui-crema_black ${pathname == "/dashboard" ? 'bg-neutral-200/80' : ''}`}>
                   <BookIcon /> <h2 className='font-semibold text-2xl'>Sources Content</h2>
                </Link>
                <Link href="/dashboard/sources"
                      className={`flex flex-row items-center justify-start gap-2 text-color-ui-crema_white font-semibold p-1 rounded-md bg-neutral-600/30 pl-4 hover:bg-neutral-400/80 hover:text-color-ui-crema_black ${pathname == "/dashboard/sources" ? 'bg-neutral-200/80' : ''}`}>
                    <SourceIcon /> <h2 className='font-semibold text-2xl'>Blocked Sources</h2>
                </Link>
            </ul>
            <div className="absolute bottom-0 pb-10 pl-10">
                <Link href="/logout"
                      className={`flex p-1 rounded-xl flex-row items-center justify-start gap-1 text-neutral-200/40 font-semibold hover:bg-neutral-400/80 hover:text-color-ui-crema_black`}>
                    <h2 className='font-semibold text-2xl text-color-ui-crema_white'>Log out</h2>
                </Link>
            </div>
        </>
    )
}